package hello.core.singleton;

public class SingletonService {

    //싱글톤 타입인 instance 변수를 선언하고 싱글톤 객체 생성해서 주입함.
    private static final SingletonService instance = new SingletonService();

    //외부에서 사용할 게터. 만들어진 싱글톤타입의 변수 instance를 반환한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //외부에서 생성을 할수없게 생성자를 막음.
    private SingletonService(){
    }

    public void login(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
