package dto;

public class CaseManagerDTO extends AbstractDTO {

    private int id;
    private String name;

    public CaseManagerDTO() {
        super("caseManager");
    }

    public CaseManagerDTO(int id, String name) {
        super("caseManager");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
