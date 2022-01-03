package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class UserWithBLOBs extends User implements Serializable {
    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private static final long serialVersionUID = 1L;
}