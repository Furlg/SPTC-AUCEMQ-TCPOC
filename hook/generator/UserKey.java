package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class UserKey implements Serializable {
    private String host;

    private String user;

    private static final long serialVersionUID = 1L;
}