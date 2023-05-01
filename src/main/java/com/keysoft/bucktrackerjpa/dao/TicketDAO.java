package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Ticket;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TicketDAO implements ITicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAllTickets() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
        Root<Ticket> ticket = cq.from(Ticket.class);
        cq.select(ticket).where(cb.equal(ticket.get("status"), "CLOSED"));
        TypedQuery<Ticket> q = entityManager.createQuery(cq);
        List<Ticket> allTickets = q.getResultList();

        return allTickets;

    }

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public Ticket getTicketById(int ticketId) {
        return entityManager.find(Ticket.class, ticketId);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        Ticket ticket1 = getTicketById(ticket.getId());

        ticket1.setDescription(ticket.getDescription());
        ticket1.setApplication(ticket.getApplication());
        ticket1.setTitle(ticket.getTitle());

        entityManager.flush();
    }

    @Override
    public void deleteTicket(int ticketId) {
        entityManager.remove(getTicketById(ticketId));

    }

    @Override
    public void closeTicket(int ticketId) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setStatus("Resolved");
    }
}
