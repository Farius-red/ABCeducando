
package util;


import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mensajes {

    
    public  static void envioMensajes(
            String host,
            String puerto, 
            final String  usuario, 
            final String clave,
            String destinatario,
            String asunto,
            String mensaje  ) throws AddressException, MessagingException{
            
        // propiedades servidor smtp 
        
       Properties propiedades = new Properties();
       propiedades.put("mail.smtp.host", host);
       propiedades.put("mail.smtp.port", puerto);
       propiedades.put("mail.smtp.auth", "true");
       propiedades.put("mail.smtp.starttls.enable", "true");
       
      Authenticator auth = new Authenticator(){
      
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(usuario, clave);
            }
      };
      
      Session sesion = Session.getInstance(propiedades, auth);
      Message msg = new MimeMessage(sesion);
      InternetAddress[] destinatarios = {  new InternetAddress(destinatario)};
        
      msg.setRecipients(Message.RecipientType.TO, destinatarios);
      msg.setSubject(asunto);
      msg.setSentDate(new Date());
      msg.setText(mensaje);
      
      
        Transport.send(msg);
    
    }
}
