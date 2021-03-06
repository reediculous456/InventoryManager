package edu.uc.inventorymanager.dto;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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
    private int id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @NonNull
    private String description;

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
