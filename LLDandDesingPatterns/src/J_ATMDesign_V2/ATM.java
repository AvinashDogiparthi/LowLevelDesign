package J_ATMDesign_V2;

import J_ATMDesign_V2.ATMStates.ATMState;
import J_ATMDesign_V2.ATMStates.IdleState;

import java.util.HashMap;
import java.util.Map;

public class ATM {

    private static ATM INSTANCE = null;

    private Map<CurrencyNotesEnum, Integer> availableCurrencyMap;
    private ATMState atmState;
    private Card card;

    private ATM(ATMState atmState) {
        this.atmState = atmState;
        this.availableCurrencyMap = new HashMap<>();
    }

    private ATM(){
        this.atmState = new IdleState();
        this.availableCurrencyMap = new HashMap<>();
        addCurrenciesInAtm();
    }

    public void addCurrenciesInAtm(){
        this.availableCurrencyMap.put(CurrencyNotesEnum.TWO_THOUSAND,10000);
        this.availableCurrencyMap.put(CurrencyNotesEnum.FIVE_HUNDRED,100000);
        this.availableCurrencyMap.put(CurrencyNotesEnum.HUNDRED,300);
        this.availableCurrencyMap.put(CurrencyNotesEnum.TWENTY,100000000);
    }

    public static synchronized ATM getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new ATM();
        }

        return INSTANCE;
    }

    public void addCurrencyNotes(CurrencyNotesEnum currencyNotesEnum, int notesCountToBeIncremented){
        if(availableCurrencyMap.containsKey(currencyNotesEnum)){
            availableCurrencyMap.put(currencyNotesEnum, availableCurrencyMap.get(currencyNotesEnum) + notesCountToBeIncremented);
        } else {
            availableCurrencyMap.put(currencyNotesEnum,notesCountToBeIncremented);
        }
    }

    public void removeCurrencyNotes(CurrencyNotesEnum currencyNotesEnum, int notesCountToBeRemoved){
        if(availableCurrencyMap.containsKey(currencyNotesEnum)){
            int availableNotes = availableCurrencyMap.get(currencyNotesEnum) - notesCountToBeRemoved;
            availableCurrencyMap.put(currencyNotesEnum, Math.max(availableNotes,0));
        } else {
            availableCurrencyMap.put(currencyNotesEnum,0);
        }
    }

    public int getSpecificCurrencyNotesCount(CurrencyNotesEnum currencyNotesEnum){
        return availableCurrencyMap.getOrDefault(currencyNotesEnum, 0);
    }

    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
