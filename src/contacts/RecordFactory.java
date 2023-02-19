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
        person.setName(mainMenu.getInput());
    }

    private void addSurname(){
        System.out.print("Enter the surname: ");
        person.setSurname(mainMenu.getInput());
    }

    private void addBirthDate(){
        System.out.print("Enter the birth date: ");
        person.setBirthDate(mainMenu.getInput());

    }

    private void addGender(){
        System.out.print("Enter the gender (M, F): ");
        person.setGender(mainMenu.getInput());
    }

    private void addPhoneNumber() {
        System.out.print("Enter the number: ");
        person.setPhoneNumber(mainMenu.getInput());
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
        organization.setOrganizationName(mainMenu.getInput());
    }

    private void addAddress() {
        System.out.print("Enter the address: ");
        organization.setAddress(mainMenu.getInput());
    }

    private void addPhoneNumber() {
        System.out.print("Enter the number: ");
        organization.setPhoneNumber(mainMenu.getInput());
    }

}
