package edu.uc.inventorymanager.dto;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @SerializedName("id")
    private int id;

    @Column(nullable = false)
    @NonNull
    @SerializedName("name")
    private String name;

    @NonNull
    @SerializedName("description")
    private String description;

    @SerializedName("location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "assignedTo")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private ItemStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
