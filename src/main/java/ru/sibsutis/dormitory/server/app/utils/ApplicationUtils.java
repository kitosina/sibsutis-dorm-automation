package ru.sibsutis.dormitory.server.app.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import ru.sibsutis.dormitory.server.app.Starter;

import java.io.InputStream;

import static org.slf4j.LoggerFactory.getLogger;

@SuppressWarnings({"checkstyle:hideutilityclassconstructor"})
public final class ApplicationUtils {

    private static final Logger LOG = getLogger(Starter.class);

    /**
     * @return Возвращает версию приложения
     */
    public static String getVersion() {
        try (InputStream is = Starter.class.getResourceAsStream("/app.version")) {
            return IOUtils.toString(is);
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
        }
        return "Unknown version project";
    }

}
