package Computador;
public class CPU {
    private final int READ          = 10; // leitura
    private final int WRITE         = 11; // escrita
    private final int LOAD          = 12; // carrega da memoria
    private final int STORE         = 13; // armazena na memoria
    private final int ADD           = 30; // soma
    private final int SUB           = 31; // subtração
    private final int MUL           = 32; // multiplicação
    private final int DIV           = 33; // divisão
    private final int MOD           = 34; // resto da divisão
    private final int BRANCE        = 40; // altera o fluxo
    private final int BRANCHNEG     = 41; 
    private final int BRANCHZERO    = 42;
    private final int HALT          = 43; // encerra a execução
    
    
    private int instructionCounter;
    private int programCounter;
    private int accumulator;
    
    private InputDevice inputDevice;
    private OutputDevice outputDevice;
    
    private Memory memory;

    public CPU(InputDevice inputDevice, OutputDevice outputDevice, Memory memory) {
        this.inputDevice = inputDevice;
        this.outputDevice = outputDevice;
        this.memory = memory;
        accumulator = 0;
        instructionCounter = 0;
        programCounter = 0;
    }
    public Opcode decodifyInstruction(int word)
    {
        Opcode op = new Opcode();
        if (word/100 == 0)
        {
            op.setInstructionCode(word%100);
            op.setOperandSpecifier(0);
        } else
        {
            op.setInstructionCode(word/100);
            op.setOperandSpecifier(word%100);
        }
        return op;
        
    }
    
    public void run(int address)
    {
        setProgramCounter(address);
        Opcode opcode;
        do
        {
            int word = memory.getWord(getProgramCounter());
            setInstructionCounter(word);
            incInstructionCounter();
            opcode = decodifyInstruction(getInstructionCounter());
            
            switch(opcode.getInstructionCode())
            {
                case READ:
                    accumulator = inputDevice.readInt();
                    incInstructionCounter();
                    break;
                case WRITE:
                    outputDevice.writeInt(accumulator);
                    incInstructionCounter();
                    break;
                case LOAD:
                    break;
                case STORE:
                    break;
                case ADD:
                    break;
                case SUB:
                    break;
                case MUL:
                    break;
                case DIV:
                    break;
                case MOD:
                    break;
                case BRANCE:
                    break;
                case BRANCHNEG:
                    break;
                case BRANCHZERO:
                    break;
                case HALT:
                    break;
            }
            
        } while(opcode.getInstructionCode() != HALT);
    }
    
    public void incInstructionCounter()
    {
        instructionCounter++;
    }
    
    
    
    
    

    public InputDevice getInputDevice() {
        return inputDevice;
    }

    public int getInstructionCounter() {
        return instructionCounter;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }

    public void setInstructionCounter(int instructionCounter) {
        this.instructionCounter = instructionCounter;
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }
    
    
    
    
}
