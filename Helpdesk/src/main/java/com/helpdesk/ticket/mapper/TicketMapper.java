package com.helpdesk.ticket.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.helpdesk.ticket.dto.TicketCollaboratorDto;
import com.helpdesk.ticket.dto.TicketDto;
import com.helpdesk.ticket.dto.TicketEventDto;
import com.helpdesk.ticket.dto.TicketMessageDto;
import com.helpdesk.ticket.entity.Ticket;
import com.helpdesk.ticket.entity.TicketCollaborator;
import com.helpdesk.ticket.entity.TicketEvent;
import com.helpdesk.ticket.entity.TicketMessage;

import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    
    TicketDto toDto(Ticket ticket);
    Ticket toEntity(TicketDto dto);


    @Mapping(source = "ticket", target = "ticketId", qualifiedByName = "ticketToId")
    TicketMessageDto toDto(TicketMessage message);

    @Mapping(source = "ticketId", target = "ticket", qualifiedByName = "idToTicket")
    TicketMessage toEntity(TicketMessageDto dto);

    TicketEventDto toDto(TicketEvent event);
    TicketEvent toEntity(TicketEventDto dto);

    TicketCollaboratorDto toDto(TicketCollaborator collaborator);
    TicketCollaborator toEntity(TicketCollaboratorDto dto);

    List<TicketDto> toDtoList(List<Ticket> tickets);
    List<TicketMessageDto> toMessageDtoList(List<TicketMessage> messages);
    List<TicketEventDto> toEventDtoList(List<TicketEvent> events);
    List<TicketCollaboratorDto> toCollaboratorDtoList(List<TicketCollaborator> collaborators);

 
    @Named("ticketToId")
    default Long mapTicketToId(Ticket ticket) {
        return ticket != null ? ticket.getId() : null;
    }

    @Named("idToTicket")
    default Ticket mapIdToTicket(Long id) {
        if (id == null) return null;
        Ticket ticket = new Ticket();
        ticket.setId(id);
        return ticket;
    }
}
