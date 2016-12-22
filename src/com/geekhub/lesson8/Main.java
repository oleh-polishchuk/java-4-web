package com.geekhub.lesson8;

public class Main {

    public static void main(String[] args) throws Exception {
        BeanRepresenter beanRepresenter = new BeanRepresenter();
        BeanComparator beanComparator = new BeanComparator();
        CloneCreator cloneCreator = new CloneCreator();

        Cat cat = new Cat("Black", 3, 35);
        Car car = new Car("Black", 190, "Sedan", "RX-7");
        Human human = new Human(180, "male", 22, 75);

        beanRepresenter.represent(cat);
        beanRepresenter.represent(car);
        beanRepresenter.represent(human);

        beanRepresenter.represent(cloneCreator.createClone(cat));
        beanRepresenter.represent(cloneCreator.createClone(car));
        beanRepresenter.represent(cloneCreator.createClone(human));

        beanComparator.compare(cat, new Cat("Black", 4, 40));
        beanComparator.compare(car, new Car("Black", 225, "Coupe", "RX-8"));
        beanComparator.compare(human, new Human(190, "female", 22, 75));
    }
}
