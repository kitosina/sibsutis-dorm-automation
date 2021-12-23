package ru.sibsutis.dormitory.server.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.sibsutis.dormitory.server.service.data.converters.DormEntityToDormDto;
import ru.sibsutis.dormitory.server.service.data.converters.PaymentTypeEntityToPaymentTypeDto;
import ru.sibsutis.dormitory.server.service.data.converters.RoomEntityToRoomDto;
import ru.sibsutis.dormitory.server.service.data.converters.SectionEntityToSectionDto;
import ru.sibsutis.dormitory.server.service.security.converters.UserInfoDtoToTenantEntity;
import ru.sibsutis.dormitory.server.service.security.converters.UserInfoDtoToUserEntity;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(new DormEntityToDormDto());
        registry.addConverter(new SectionEntityToSectionDto());
        registry.addConverter(new RoomEntityToRoomDto());
        registry.addConverter(new UserInfoDtoToTenantEntity());
        registry.addConverter(new PaymentTypeEntityToPaymentTypeDto());
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/home_page").setViewName("home_page");
        registry.addViewController("/kvitancii").setViewName("kvitancii");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/personal_data").setViewName("personal_data");
        registry.addViewController("/registration_view").setViewName("registration");
        registry.addViewController("/repair").setViewName("repair");
        registry.addViewController("/spravki").setViewName("spravki");
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
