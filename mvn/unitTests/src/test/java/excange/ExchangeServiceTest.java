package excange;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ExchangeServiceTest {

    @Disabled
    @Test
    void exchange() {

        Ammount ammount = mock(Ammount.class);
        when(ammount.getAmmount(anyInt())).thenReturn(BigDecimal.ONE);
        Rate rate = mock(Rate.class);
        when(rate.getRate(anyString())).thenReturn(BigDecimal.TEN);

        ExchangeService exchangeService = new ExchangeService(ammount, rate);

        System.out.println(exchangeService.exchange(11111));
    }

    @Test
    void test(){
        ExchangeService es = new ExchangeService(new Ammount(), new Rate());

        System.out.println(es.exchange(111));

    }
}