package lesson03.demo.association;

/**
 * 人类
 */
class Person {
    /**
     * 证件对象
     */
   private IdentityCard ic;

   public Person(IdentityCard ic) {
       this.ic = ic;
   }

    public IdentityCard getIc() {
        return ic;
    }

    public void setIc(IdentityCard ic) {
        this.ic = ic;
    }
}

/**
 * 证件类
 */
class IdentityCard {

}

public class OneToOne {
}
