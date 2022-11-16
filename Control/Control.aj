package Control;

public aspect Control {

	after():
		call(* *.start()){
			System.out.println("Se inicio un hilo");
	}
}