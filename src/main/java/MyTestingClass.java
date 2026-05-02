public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 17;

        hash = 31 * hash + id;

        if (name != null) {
            for (int i = 0; i < name.length(); i++) {
                hash = 31 * hash + name.charAt(i);
            }
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MyTestingClass)) {
            return false;
        }

        MyTestingClass other = (MyTestingClass) obj;

        if (this.id != other.id) {
            return false;
        }

        if (this.name == null && other.name != null) {
            return false;
        }

        if (this.name != null && !this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}






