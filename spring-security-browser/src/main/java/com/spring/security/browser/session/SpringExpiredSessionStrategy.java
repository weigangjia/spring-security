package com.spring.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 类名称：SpringExpiredSessionStrategy<br>
 * 类描述：<br>
 * 创建时间：2019年03月29日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
public class SpringExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public SpringExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
