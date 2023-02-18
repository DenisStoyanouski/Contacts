package contacts;

public interface RecordFactory {
    Record createRecord();
}

class PersonFactory implements RecordFactory {
    private Person person;

    PersonFactory() {
        person = new Person();
    }

    @Override
    public Record createRecord() {
        addName();
        addSurname();
        addBirthDate();
        addGender();
        addPhoneNumber();
        return person;
    }

    private void addName(){
        System.out.print("Enter the name: ");
        person.setName(Menu.getInput());
    }

    private void addSurname(){
        System.out.print("Enter the surname: ");
        person.setSurname(Menu.getInput());
    }

    private void addBirthDate(){
        System.out.print("Enter the birth date: ");
        person.setBirthDate(Menu.getInput());

    }

    private void addGender(){
        System.out.print("Enter the gender (M, F): ");
        person.setGender(Menu.getInput());
    }

    private void addPhoneNumber() {
        System.out.print("Enter the number: ");
        person.setPhoneNumber(Menu.getInput());
    }
}

class OrganizationFactory implements RecordFactory {

    private Organization organization;

    OrganizationFactory() {
        organization = new Organization();
    }

    @Override
    public Record createRecord() {
        addOrganizationName();
        addAddress();
        addPhoneNumber();
        return organization;
    }

    private void addOrganizationName() {
        System.out.print("Enter the organization name: ");
        organization.setOrganizationName(Menu.getInput());
    }

    private void addAddress() {
        System.out.print("Enter the address: ");
        organization.setAddress(Menu.getInput());
    }

    private void addPhoneNumber() {
        System.out.print("Enter the number: ");
        organization.setPhoneNumber(Menu.getInput());
    }

}
