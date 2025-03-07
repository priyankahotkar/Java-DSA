class Parent {
    public void publicMethod() {
        System.out.println("Parent's public method");
    }
    
    protected void protectedMethod() {
        System.out.println("Parent's protected method");
    }
    
    void defaultMethod() {
        System.out.println("Parent's default method");
    }
    
    private void privateMethod() {
        System.out.println("Parent's private method");
    }
}

class Child extends Parent {
    public static void main(String[] args) {
        Child child = new Child();
        child.publicMethod(); // Can access public method of parent
        child.protectedMethod(); // Can access protected method of parent
        child.defaultMethod(); // Can access default method of parent
        // child.privateMethod(); // Can't access private method of parent
    }
}
