package com.db.persistence.services.internal;

import com.db.persistence.scheme.Revision;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by taljmars on 4/29/17.
 */
@Lazy
@Component
public class RevisionManager {

    final static Logger logger = Logger.getLogger(RevisionManager.class);

    @PersistenceContext
    private EntityManager entityManager;

    private Revision initializeRevision() {
        Revision revision = new Revision();
        revision.setCurrentRevision(0);
        revision.getKeyId().setPrivatelyModified(false);
        revision.getKeyId().setToRevision(0);
        logger.debug("First time creating revision " + revision);
        entityManager.persist(revision);
        revision = entityManager.find(Revision.class, revision.getKeyId());
        return revision;
    }

    private Revision getRevisionObject() {
        Query query = entityManager.createNativeQuery("SELECT * FROM revision", Revision.class);
        List<Revision> list = query.getResultList();
        if (list.size() != 0)
            return list.get(0);

        return initializeRevision();
    }

    public int getNextRevision() {
        return getRevisionObject().getCurrentRevision() + 1;
    }

    public void advance() {
        Revision revision = getRevisionObject();
        revision.setCurrentRevision(getNextRevision());
        entityManager.flush();
    }
}