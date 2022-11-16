public aspect Control {

	after():
		call(* *.start()){
			System.out.println("Se inicio un hilo");
	}
	
	before(int code): 
		call(* System.exit(int)) && args(code) {
			if(code == 0)
				System.out.println("Salida exitosa"); 
			else
				System.out.println("Salida defectuosa"); 
	}
}