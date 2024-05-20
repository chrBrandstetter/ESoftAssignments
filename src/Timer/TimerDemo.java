package Timer;

class TimerDemo {
	
	public static void main(String[] args) {
		
		Out.print("\nCONSTRUCTORS ---------------------");
		Timer t1 = new Timer();
		Out.print("\nt1: " + t1.asText());
		
		Timer t2 = new Timer(24,0,0);
		Out.print("\nt2: " + t2.asText());
		
		Timer t3 = new Timer(-1,0,0);
		Out.print("\nt3: " + t3.asText());
		
		Timer t4 = new Timer(2,15,9);
		Out.print("\nt4: " + t4.asText());
		
		Out.print("\nELAPSE sec ---------------------");
		boolean b = t4.elapse(15*60+10);
		Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);
		
		Out.print("\nELAPSE min ---------------------");
		t4.reset();
		Out.print("\nt4: " + t4.asText());
		b = t4.elapse(16,10);
		Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);
		
		Timer t5 = new Timer(1,0,0);
		Out.print("\nt5: " + t5.asText());
		b = t5.elapse(60*60);
		Out.print("\nt5: " + t5.asText()+ " Rueckgabewert:" +b);
		
		
		Out.print("\nELAPSE h ---------------------");
		t4.reset();
		Out.print("\nt4: " + t4.asText());
		b = t4.elapse(1,16,10);
		Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);
		
		t4.reset();
		Out.print("\nt4: " + t4.asText());
		b = t4.elapse(1*60*60+16*60+10);
		Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);
		
		Out.print("\nWITHDRAW sec ---------------------");
		t4.reset();
		Out.print("\nt4: " + t4.asText());
		b = t4.withdraw(10);
		Out.print("\nt4: " + t4.asText()+ " Rueckgabewert:" +b);
		
		Out.print("\nWITHDRAW sec ---------------------");
		t4.reset();
		Out.print("\nt4: " + t4.asText());
		Timer t7	= t4.cloneIt();
		Out.print("\nt4: " + t7.asText()+ " Rueckgabewert:" +b);
		
		Out.print("\nDIFF timer ---------------------");
		t4.reset();
		Out.print("\nt2: " + t2.asText());
		Out.print("\nt4: " + t4.asText());
		Timer t6= t2.diff(t4);
		Out.print("\nt6: " + t6.asText());
		
		
	} // end main()
} // end class TimerDemo
