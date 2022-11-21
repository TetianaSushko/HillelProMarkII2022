package subscriber.service;

import subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriberServiceTest implements SubscriberService {
    @Override
    public List<Subscriber> checkTimeCityConversation(List<Subscriber> subscriber, int timeCity) {
        return new ArrayList<>();
    }

    @Override
    public List<Subscriber> checkUsersWhoUseIntercityConnection(ArrayList<Subscriber> subscriber) {
        return new ArrayList<>();
    }

    @Override
    public List<Subscriber> alphabetSort(ArrayList<Subscriber> subscriber, char letter) {
        return new ArrayList<>();
    }

    @Override
    public int checkInternetTraffic(ArrayList<Subscriber> subscriber, String city) {
        return 0;
    }

    @Override
    public int numberOfAbonentWithNegativeBalance(ArrayList<Subscriber> subscriber) {
        return 0;
    }
}
