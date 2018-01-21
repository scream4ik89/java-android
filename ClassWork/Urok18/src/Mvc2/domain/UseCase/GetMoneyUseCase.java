package Mvc2.domain.UseCase;

import Mvc2.domain.entity.GetMoneyResult;
import Mvc2.domain.entity.Money;
import Mvc2.domain.repository.MoneyRepository;

public class GetMoneyUseCase implements UseCase{
    private MoneyRepository moneyRepository;

    public GetMoneyUseCase(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    public void execute(Money money, getMoneyListener resultListener) {// сколько денег мы хотим снять и куда записать
        // получааем текущее количество денег
        Money currentMoney = moneyRepository.get();
        //проверяем достаточно ли денег для снятия
        if(currentMoney.getMoney() >= money.getMoney()){
            Money newMoney = new Money();
            newMoney.setMoney(currentMoney.getMoney() - money.getMoney());
            //сохраняем новое количество денег
            moneyRepository.save(newMoney);

            GetMoneyResult result = new GetMoneyResult();
            resultListener.onResult(result);
        } else {
            //возвращаем рузультат в presentation слой
            resultListener.onError();}

    }

    interface getMoneyListener{
        void onResult(GetMoneyResult getMoneyResult);
        void onError();
    }
}
