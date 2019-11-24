package com.wb.game;

public enum InputType {
	R("ROCK"),
	P("PAPER"),
	S("SCISSORS");
	
	private static InputType[] inputs = InputType.values();
	
	private String name;
		
	InputType(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public static InputType valueOf(int i){
		return inputs[i];
	}
	
	public static String displayOptions(){
		StringBuffer sb = new StringBuffer();
		for (InputType input : InputType.values()){
			sb.append("( ").append(input).append(" -> ").append(input.name).append(" )");
		}
		return sb.toString();
	}
}
