package be.cegeka.vconsult.consult.config;

import org.eclipse.jetty.rewrite.handler.RewriteHandler;
import org.eclipse.jetty.rewrite.handler.RewritePatternRule;
import org.eclipse.jetty.server.Server;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class JettyHandlerConfiguration {

    //    @Bean
    //    @Primary
    //    public JettyEmbeddedServletContainerFactory factory(@Value("${server.port:8080}") final String port) {
    //        final JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory(Integer.valueOf(port));
    //        factory.addServerCustomizers(new RedirectHandler());
    //        return factory;
    //    }

    @Bean
    public EmbeddedServletContainerCustomizer servletConfig() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof JettyEmbeddedServletContainerFactory) {
                    ((JettyEmbeddedServletContainerFactory) container).addServerCustomizers(new RedirectHandler());
                }
            }
        };
    }

    private static class RedirectHandler implements JettyServerCustomizer {

        private final RewriteHandler rewrite = new RewriteHandler();

        public RedirectHandler() {
            rewrite.setRewriteRequestURI(true);
            rewrite.setRewritePathInfo(false);

            RewritePatternRule rule = new RewritePatternRule();
            rule.setPattern("/webservices/*");
            rule.setReplacement("/abc/webservices/");
            rewrite.addRule(rule);
        }

        @Override
        public void customize(Server server) {
            server.setHandler(rewrite);
        }
    }


}
