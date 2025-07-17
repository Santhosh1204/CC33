package com.helpdesk.ticket.serviceImpl;

import com.helpdesk.ticket.dto.TicketMessageDto;
import com.helpdesk.ticket.entity.TicketMessage;
import com.helpdesk.ticket.mapper.TicketMapper;
import com.helpdesk.ticket.repository.TicketMessageRepository;
import com.helpdesk.ticket.service.TicketMessageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketMessageServiceImpl implements TicketMessageService {

    private final TicketMessageRepository messageRepository;
    private final TicketMapper mapper;

    @Override
    public List<TicketMessageDto> getMessagesByTicketId(Long ticketId) {
        List<TicketMessage> messages = messageRepository.findByTicketId(ticketId);
        return mapper.toMessageDtoList(messages);
    }
}

