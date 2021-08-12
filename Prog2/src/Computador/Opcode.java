package Computador;
public class Opcode {
    private int instructionCode;
    private int operandSpecifier;

    public void setInstructionCode(int instructionCode) {
        this.instructionCode = instructionCode;
    }

    public void setOperandSpecifier(int operandSpecifier) {
        this.operandSpecifier = operandSpecifier;
    }

    public int getInstructionCode() {
        return instructionCode;
    }

    public int getOperandSpecifier() {
        return operandSpecifier;
    }
    
}
