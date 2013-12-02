package cn.nbcc.chap05.snippets;



public class Inherits {
	
	public void doServiece() {
		System.out.println("Inherites do services");
	}
	
	public class Some extends Inherits{
		@Override
		public void doServiece() {
			System.out.println("Some do servieces");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Inherits it = new Inherits();
		Inherits i = it.new Some();
		i.doServiece();
	}

}
