package com.baeldung.criteriaapi;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getHibernateSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = cb.createQuery(Item.class);
        Root<Item> root = cr.from(Item.class);
        cr.select(root);

        Query<Item> query = session.createQuery(cr);
        List<Item> results = query.getResultList();
    }
}
