package subscriber.service;

import org.junit.jupiter.api.Test;
import subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SubscriberServiceImplTest {

    SubscriberService sbService = new SubscriberServiceImpl();

    @Test
    void checkTimeCityConversation() {
        List<Subscriber> sbList = new ArrayList<>();
        sbList.add(new Subscriber().setName("1").setTimeCityConversation(10));
        sbList.add(new Subscriber().setName("2").setTimeCityConversation(0));
        sbList.add(new Subscriber().setName("3").setTimeCityConversation(-10));

        List<Subscriber> result = sbService.checkTimeCityConversation(sbList, 0);

        assertEquals(2, result.size());

     }

     @Test
     void checkTimeCityConversationMock() {
         List<Subscriber> sbList = new ArrayList<>();
         sbList.add(new Subscriber().setName("1").setTimeCityConversation(10));
         sbList.add(new Subscriber().setName("2").setTimeCityConversation(0));
         sbList.add(new Subscriber().setName("3").setTimeCityConversation(-10));


         List<Subscriber> sbList1 = new ArrayList<>();
         sbList1.add(new Subscriber().setName("1").setTimeCityConversation(10));

         SubscriberServiceImpl sbServiceMock = mock(SubscriberServiceImpl.class);

         when(sbServiceMock.checkTimeCityConversation(anyList(), anyInt())).thenReturn(sbList);
         when(sbServiceMock.checkTimeCityConversation(anyList(), eq(1))).thenReturn(sbList1);

         System.out.println(sbServiceMock.checkTimeCityConversation(List.of(), 4));
         System.out.println("===========");
         System.out.println(sbServiceMock.checkTimeCityConversation(List.of(), 1));
     }

    @Test
    void checkUsersWhoUseIntercityConnection() {
    }

    @Test
    void alphabetSort() {
    }

    @Test
    void checkInternetTraffic() {
    }

    @Test
    void numberOfAbonentWithNegativeBalance() {
    }
}