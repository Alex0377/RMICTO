import java.util.Random;


public class Quotes {
    String quote ;


    public String returnQuotes(){
    Random ran = new Random();
        int num = ran.nextInt(7);
        switch (num) {
            case 0:
               quote  = "Лучший способ сделать\n"
                        + "карьеру – работать на того,\n"
                        + "кто делает карьеру.\n\n";
                break;
            case 1:
                 quote  = "Чтобы быть умным, не\n"
                        + ", не обязательно много учиться.\n"
                        + "Чтобы быть богатым,\n\n"
                        + ", не обязательно много работать.";
                break;
            case 2:
                    quote  = "Просто так не звонят, просто так не пишут.\n"
                        + "Во всем есть повод, во всем есть смысл.\n";
                break;
            case 3:

                quote  = "Лучше я буду получать 1% денег\n"
                        + "в результате усилий 100 человек,\n\n"
                        + " чем 100% в результате своих собственных";

                break;
            case 4:
                //Вся твоя жизнь на 90 % зависит от тебя самого и лишь на 10 % от обстоятельств, которые на 99 % зависят от тебя.
                quote  = "Вся твоя жизнь на 90 % зависит от тебя самого\n"
                        + "и лишь на 10 % от обстоятельств.\n\n"
                        + "которые на 99 % зависят от тебя.";
                break;
            case 5:
                quote  = "Лучше я буду получать 1%\n"
                        + "в результате усилий 100 человек,\n\n"
                        + ", чем 100% в результате своих собственных усилий.";
                break;

            case 6:
                quote  = "Я отдыхаю, когда работаю,\n"
                        + " и устаю, когда бездельничаю.\n\n"
                        + "или принимаю гостей.";
    }
    return quote;
    }
}