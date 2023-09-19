package pl.sdacademy.booking.service;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.repository.EntityRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EventService {

        private final EntityRepository entityRepository;

        public EventService(EntityRepository entityRepository) {
            this.entityRepository = entityRepository;
        }
        public List<EventDto> findAll() {
            log.info("findAll Events");
            List<EventEntity> eventEntities = entityRepository.findAll();
            List<EventDto> eventDto = new ArrayList<>();

            for (EventEntity eventEntity : eventEntities) {
                eventDto.add(mapToEventDto(eventEntity));
            }

            return eventDto;
        }

    private EventDto mapToEventDto(EventEntity eventEntity) {
        return EventDto.builder()
                .name(eventEntity.getItem().getName())
                .price(eventEntity.getItem().getPrice())
                .fromTime(eventEntity.getFrom())
                .toTime(eventEntity.getTo())
                .build();
    }
}
