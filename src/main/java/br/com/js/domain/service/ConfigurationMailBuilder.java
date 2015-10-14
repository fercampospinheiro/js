
package br.com.js.domain.service;

/**
 *
 * @author fernando
 */
public class ConfigurationMailBuilder {
    
    private ConfigurationMail configurationEmail;

    public ConfigurationMailBuilder() {
        this.configurationEmail = new ConfigurationMail();
    }
    
    public ConfigurationMailBuilder SMTP(String stmp){
        this.configurationEmail.put("mail.transport.protocol", "smtp");
        this.configurationEmail.put("mail.smtp.host",stmp);
        return this;
    }
    
    public ConfigurationMailBuilder portSMTPserver(String port){
        this.configurationEmail.put("mail.smtp.socketFactory.port", port);
        return this;
    }
    
    
    public ConfigurationMailBuilder TLS(boolean status){
        this.configurationEmail.put("mail.smtp.starttls.enable",status);
        return this;
    }
    
    public ConfigurationMailBuilder Authentication(boolean status ){
       this.configurationEmail.put("mail.smtp.auth", status);
        return this;  
    }
    public ConfigurationMailBuilder USER(String user){
        this.configurationEmail.put("mail.smtp.user", user);
        return this;
    }
    
    public ConfigurationMailBuilder modeDebug(boolean status){
        this.configurationEmail.put("mail.debug", status);
        return this;
    }
    
    public ConfigurationMailBuilder classSocket(String classSocket){
        this.configurationEmail.put("mail.smtp.socketFactory.class", classSocket);
        return this;
    }
    
    public ConfigurationMailBuilder fallback(boolean status){
        this.configurationEmail.put("mail.smtp.socketFactory.fallback", status);
        return this;
    }
		  
    public ConfigurationMailBuilder getConfigurationDefault(){
        this.SMTP("smtp.gmail.com")
                .portSMTPserver("465")
                .TLS(true)
                .Authentication(true)
                .classSocket("javax.net.ssl.SSLSocketFactory")
                .modeDebug(true)
                .fallback(false);
        return this;
    }  
    
    public ConfigurationMail builder(){
        return this.configurationEmail;
    }
    
    
}
