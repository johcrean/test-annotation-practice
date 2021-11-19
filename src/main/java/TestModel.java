import annotations.markTest;

public class TestModel {
    private String name;
    private int age;

    static TestModel test1 = new TestModel(25, "Rob");
    static TestModel test2 = new TestModel(20,"Sam");
    static TestModel test3;


    public TestModel(){

    }

    public TestModel(int age, String name){
        this.age = age;
        this.name = name;
    }

    public boolean getBoolean(){
        return false;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public static void assertAgeEquals(TestModel o1, TestModel o2){
        System.out.println("Testing if test1's age equals test2's age.");
        if(o1.age == o2.age){
            System.out.println("Equal");
        }else{
            System.out.println("False.");
            System.out.println("Expected: " + o1.age);
            System.out.println("Actual: " + o2.age);
        }
        System.out.println();
    }

    public static void assertNameEquals(TestModel o1, TestModel o2){
        System.out.println("Testing if test1's name equals test2's name.");
        if(o1.name.equals(o2.name)){
            System.out.println("Equal.");
        }else{
            System.out.println("False.");
            System.out.println("Expected: " + o1.name);
            System.out.println("Actual: " + o2.name);
        }
        System.out.println();
    }

    public static void testNull(TestModel o1){
        System.out.println("Testing if object is null.");
        if(o1==null){
            System.out.println("Null");
        }else{
            System.out.println("Exists");
        }
        System.out.println();
    }

    public static void testEquals(TestModel o1, TestModel o2){
        System.out.println("Testing if objects are the same.");
        if(o1.equals(o2)){
            System.out.println("Same object reference.");
        }else{
            System.out.println("Not the same object.");
        }
        System.out.println();
    }

    @markTest
    public static void ageEqual(){
        assertAgeEquals(test1,test2);
    }

    @markTest
    public static void nameEqual(){
        assertNameEquals(test1,test2);
    }

    @markTest
    public static void notNull(){
        testNull(test1);
    }

    @markTest
    public static void isNull(){
        testNull(test3);
    }

    @markTest
    public static void objEquals(){
        testEquals(test1,test2);
        testEquals(test1,test1);
    }


}
