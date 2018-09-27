package com.newt.pojo.partial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginNumIsNull() {
            addCriterion("LOGIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andLoginNumIsNotNull() {
            addCriterion("LOGIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNumEqualTo(Integer value) {
            addCriterion("LOGIN_NUM =", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumNotEqualTo(Integer value) {
            addCriterion("LOGIN_NUM <>", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumGreaterThan(Integer value) {
            addCriterion("LOGIN_NUM >", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_NUM >=", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumLessThan(Integer value) {
            addCriterion("LOGIN_NUM <", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumLessThanOrEqualTo(Integer value) {
            addCriterion("LOGIN_NUM <=", value, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumIn(List<Integer> values) {
            addCriterion("LOGIN_NUM in", values, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumNotIn(List<Integer> values) {
            addCriterion("LOGIN_NUM not in", values, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_NUM between", value1, value2, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginNumNotBetween(Integer value1, Integer value2) {
            addCriterion("LOGIN_NUM not between", value1, value2, "loginNum");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("LOGIN_TIME =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("LOGIN_TIME <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("LOGIN_TIME >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("LOGIN_TIME <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("LOGIN_TIME in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("LOGIN_TIME not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpIsNull() {
            addCriterion("OLD_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpIsNotNull() {
            addCriterion("OLD_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpEqualTo(String value) {
            addCriterion("OLD_LOGIN_IP =", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpNotEqualTo(String value) {
            addCriterion("OLD_LOGIN_IP <>", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpGreaterThan(String value) {
            addCriterion("OLD_LOGIN_IP >", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_LOGIN_IP >=", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpLessThan(String value) {
            addCriterion("OLD_LOGIN_IP <", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpLessThanOrEqualTo(String value) {
            addCriterion("OLD_LOGIN_IP <=", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpLike(String value) {
            addCriterion("OLD_LOGIN_IP like", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpNotLike(String value) {
            addCriterion("OLD_LOGIN_IP not like", value, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpIn(List<String> values) {
            addCriterion("OLD_LOGIN_IP in", values, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpNotIn(List<String> values) {
            addCriterion("OLD_LOGIN_IP not in", values, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpBetween(String value1, String value2) {
            addCriterion("OLD_LOGIN_IP between", value1, value2, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpNotBetween(String value1, String value2) {
            addCriterion("OLD_LOGIN_IP not between", value1, value2, "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeIsNull() {
            addCriterion("OLG_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeIsNotNull() {
            addCriterion("OLG_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeEqualTo(Date value) {
            addCriterion("OLG_LOGIN_TIME =", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeNotEqualTo(Date value) {
            addCriterion("OLG_LOGIN_TIME <>", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeGreaterThan(Date value) {
            addCriterion("OLG_LOGIN_TIME >", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OLG_LOGIN_TIME >=", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeLessThan(Date value) {
            addCriterion("OLG_LOGIN_TIME <", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("OLG_LOGIN_TIME <=", value, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeIn(List<Date> values) {
            addCriterion("OLG_LOGIN_TIME in", values, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeNotIn(List<Date> values) {
            addCriterion("OLG_LOGIN_TIME not in", values, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeBetween(Date value1, Date value2) {
            addCriterion("OLG_LOGIN_TIME between", value1, value2, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andOlgLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("OLG_LOGIN_TIME not between", value1, value2, "olgLoginTime");
            return (Criteria) this;
        }

        public Criteria andPickNameIsNull() {
            addCriterion("PICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPickNameIsNotNull() {
            addCriterion("PICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPickNameEqualTo(String value) {
            addCriterion("PICK_NAME =", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameNotEqualTo(String value) {
            addCriterion("PICK_NAME <>", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameGreaterThan(String value) {
            addCriterion("PICK_NAME >", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameGreaterThanOrEqualTo(String value) {
            addCriterion("PICK_NAME >=", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameLessThan(String value) {
            addCriterion("PICK_NAME <", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameLessThanOrEqualTo(String value) {
            addCriterion("PICK_NAME <=", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameLike(String value) {
            addCriterion("PICK_NAME like", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameNotLike(String value) {
            addCriterion("PICK_NAME not like", value, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameIn(List<String> values) {
            addCriterion("PICK_NAME in", values, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameNotIn(List<String> values) {
            addCriterion("PICK_NAME not in", values, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameBetween(String value1, String value2) {
            addCriterion("PICK_NAME between", value1, value2, "pickName");
            return (Criteria) this;
        }

        public Criteria andPickNameNotBetween(String value1, String value2) {
            addCriterion("PICK_NAME not between", value1, value2, "pickName");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("SALT is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("SALT is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("SALT =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("SALT <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("SALT >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("SALT >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("SALT <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("SALT <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("SALT like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("SALT not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("SALT in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("SALT not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("SALT between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("SALT not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("SIGNATURE is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("SIGNATURE is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("SIGNATURE =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("SIGNATURE <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("SIGNATURE >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("SIGNATURE >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("SIGNATURE <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("SIGNATURE <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("SIGNATURE like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("SIGNATURE not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("SIGNATURE in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("SIGNATURE not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("SIGNATURE between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("SIGNATURE not between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNull() {
            addCriterion("USER_ICON is null");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNotNull() {
            addCriterion("USER_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andUserIconEqualTo(String value) {
            addCriterion("USER_ICON =", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotEqualTo(String value) {
            addCriterion("USER_ICON <>", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThan(String value) {
            addCriterion("USER_ICON >", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ICON >=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThan(String value) {
            addCriterion("USER_ICON <", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThanOrEqualTo(String value) {
            addCriterion("USER_ICON <=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLike(String value) {
            addCriterion("USER_ICON like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotLike(String value) {
            addCriterion("USER_ICON not like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconIn(List<String> values) {
            addCriterion("USER_ICON in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotIn(List<String> values) {
            addCriterion("USER_ICON not in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconBetween(String value1, String value2) {
            addCriterion("USER_ICON between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotBetween(String value1, String value2) {
            addCriterion("USER_ICON not between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andFaviconIsNull() {
            addCriterion("FAVICON is null");
            return (Criteria) this;
        }

        public Criteria andFaviconIsNotNull() {
            addCriterion("FAVICON is not null");
            return (Criteria) this;
        }

        public Criteria andFaviconEqualTo(String value) {
            addCriterion("FAVICON =", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconNotEqualTo(String value) {
            addCriterion("FAVICON <>", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconGreaterThan(String value) {
            addCriterion("FAVICON >", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconGreaterThanOrEqualTo(String value) {
            addCriterion("FAVICON >=", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconLessThan(String value) {
            addCriterion("FAVICON <", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconLessThanOrEqualTo(String value) {
            addCriterion("FAVICON <=", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconLike(String value) {
            addCriterion("FAVICON like", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconNotLike(String value) {
            addCriterion("FAVICON not like", value, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconIn(List<String> values) {
            addCriterion("FAVICON in", values, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconNotIn(List<String> values) {
            addCriterion("FAVICON not in", values, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconBetween(String value1, String value2) {
            addCriterion("FAVICON between", value1, value2, "favicon");
            return (Criteria) this;
        }

        public Criteria andFaviconNotBetween(String value1, String value2) {
            addCriterion("FAVICON not between", value1, value2, "favicon");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("USER_PHONE =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("USER_PHONE <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("USER_PHONE >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("USER_PHONE <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("USER_PHONE like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("USER_PHONE not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("USER_PHONE in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("USER_PHONE not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("USER_PHONE between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USER_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USER_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USER_PWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USER_PWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USER_PWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USER_PWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_PWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USER_PWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USER_PWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USER_PWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USER_PWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USER_PWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USER_PWD not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria and( String condition) {
            addCriterion(condition);
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(USER_ID) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("upper(EMAIL) like", value.toUpperCase(), "email");
            return (Criteria) this;
        }

        public Criteria andLoginIpLikeInsensitive(String value) {
            addCriterion("upper(LOGIN_IP) like", value.toUpperCase(), "loginIp");
            return (Criteria) this;
        }

        public Criteria andOldLoginIpLikeInsensitive(String value) {
            addCriterion("upper(OLD_LOGIN_IP) like", value.toUpperCase(), "oldLoginIp");
            return (Criteria) this;
        }

        public Criteria andPickNameLikeInsensitive(String value) {
            addCriterion("upper(PICK_NAME) like", value.toUpperCase(), "pickName");
            return (Criteria) this;
        }

        public Criteria andSaltLikeInsensitive(String value) {
            addCriterion("upper(SALT) like", value.toUpperCase(), "salt");
            return (Criteria) this;
        }

        public Criteria andSignatureLikeInsensitive(String value) {
            addCriterion("upper(SIGNATURE) like", value.toUpperCase(), "signature");
            return (Criteria) this;
        }

        public Criteria andUserIconLikeInsensitive(String value) {
            addCriterion("upper(USER_ICON) like", value.toUpperCase(), "userIcon");
            return (Criteria) this;
        }

        public Criteria andFaviconLikeInsensitive(String value) {
            addCriterion("upper(FAVICON) like", value.toUpperCase(), "favicon");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLikeInsensitive(String value) {
            addCriterion("upper(USER_PHONE) like", value.toUpperCase(), "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPwdLikeInsensitive(String value) {
            addCriterion("upper(USER_PWD) like", value.toUpperCase(), "userPwd");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}