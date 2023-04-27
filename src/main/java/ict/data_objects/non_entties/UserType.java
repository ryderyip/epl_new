package ict.data_objects.non_entties;

public enum UserType {
    MEMBER("0"),
    STAFF("1"),
    MANAGER("2");
    
    public final String id;

    UserType(String text) {
        this.id = text;
    }

    public static UserType fromInt(String id) {
        for (UserType type : UserType.values())
            if (type.id.equals(id)) return type;
        throw new IllegalArgumentException("No constant with text " + id + " found");
    }
}
