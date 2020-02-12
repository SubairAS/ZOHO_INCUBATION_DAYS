package ThemePark;

public class Testing {
public static void main(String[] args) {
	Visitor visitor=new Visitor.VisitorBuilder(1).setCredits(1000).getVisitor();
	Canteen.shopCounter(visitor);
}
}
