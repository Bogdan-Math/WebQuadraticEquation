package model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "global_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;

    public boolean isNew() {
        return null == this.id;
    }

    @Override
    public String toString() {
        return id.toString() + ": ";
    }
}
