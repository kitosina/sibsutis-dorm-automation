package ru.sibsutis.dormitory.server.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserBasicInfoDto;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserInfoDto;
import ru.sibsutis.dormitory.server.model.entity.security.Role;
import ru.sibsutis.dormitory.server.model.entity.security.UserEntity;
import ru.sibsutis.dormitory.server.repository.security.UserRepository;
import ru.sibsutis.dormitory.server.service.security.converters.UserInfoDtoToUserEntity;
import ru.sibsutis.dormitory.server.service.security.strategy.RegistrationStrategy;
import ru.sibsutis.dormitory.server.service.security.strategy.RegistrationStrategyHolder;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RegistrationStrategyHolder registrationStrategyHolder;
    private final PasswordEncoder bCryptPasswordEncoder;

    private static final String MSG_USER_NOT_FOUND = "Пользователь с email %s не найден в системе";
    private static final String MSG_USER_FOUND = "Пользователь с email %s уже есть в системе";

    /**
     * Поиск зарегистрированного пользователя
     * @param email - email пользователя
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(MSG_USER_NOT_FOUND, email))); //TODO: Создать исключение?
        return new User(userEntity.getEmail(), userEntity.getPassword(), listAuthority(userEntity.getRoles()));
    }

    @Transactional(rollbackFor = Exception.class)
    public void registrationUser(final MultipartFile documentScanOne, final MultipartFile documentScanTwo,
                                 final UserInfoDto userInfoDto) {
        Optional<UserEntity> userEmail = userRepository.findByEmail(userInfoDto.getUserBasicInfoDto().getUserEmail());
        if (userEmail.isPresent()) {
            throw new RuntimeException(String.format(MSG_USER_FOUND, userEmail.get().getEmail()));
        }

        RegistrationStrategy registrationStrategy = registrationStrategyHolder
                .getStrategy(userInfoDto.getStrategyRegistration());
        Set<Role> roleSet = registrationStrategy.getRegistrationRoleUser();

        // Сохраняем пользователя в систему (email, password)
        UserBasicInfoDto userBasicInfoDto = userInfoDto.getUserBasicInfoDto();
        userRepository.save(new UserInfoDtoToUserEntity()
                .convert(userBasicInfoDto.getUserEmail(),
                        bCryptPasswordEncoder.encode(userBasicInfoDto.getUserPassword()),
                        roleSet));

        // Сохраняем информацию о пользователе
        registrationStrategy.registrationUser(documentScanOne, documentScanTwo, userInfoDto);
    }


    /**
     * Метод для пробега по всем ролям пользователя
     * @param roles коллекция ролей пользователя
     * @see GrantedAuthority
     * @see Collection
     * @return коллекция ролей пользователя
     */
    private Collection<? extends GrantedAuthority> listAuthority(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }
}
