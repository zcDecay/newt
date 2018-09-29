package com.newt.pojo.partial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionIsNull() {
            addCriterion("OPERATION_FUNCTION is null");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionIsNotNull() {
            addCriterion("OPERATION_FUNCTION is not null");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionEqualTo(String value) {
            addCriterion("OPERATION_FUNCTION =", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionNotEqualTo(String value) {
            addCriterion("OPERATION_FUNCTION <>", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionGreaterThan(String value) {
            addCriterion("OPERATION_FUNCTION >", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_FUNCTION >=", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionLessThan(String value) {
            addCriterion("OPERATION_FUNCTION <", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_FUNCTION <=", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionLike(String value) {
            addCriterion("OPERATION_FUNCTION like", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionNotLike(String value) {
            addCriterion("OPERATION_FUNCTION not like", value, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionIn(List<String> values) {
            addCriterion("OPERATION_FUNCTION in", values, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionNotIn(List<String> values) {
            addCriterion("OPERATION_FUNCTION not in", values, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionBetween(String value1, String value2) {
            addCriterion("OPERATION_FUNCTION between", value1, value2, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andOperationFunctionNotBetween(String value1, String value2) {
            addCriterion("OPERATION_FUNCTION not between", value1, value2, "operationFunction");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNull() {
            addCriterion("OPERATION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIsNotNull() {
            addCriterion("OPERATION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTypeEqualTo(Integer value) {
            addCriterion("OPERATION_TYPE =", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotEqualTo(Integer value) {
            addCriterion("OPERATION_TYPE <>", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThan(Integer value) {
            addCriterion("OPERATION_TYPE >", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATION_TYPE >=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThan(Integer value) {
            addCriterion("OPERATION_TYPE <", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATION_TYPE <=", value, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeIn(List<Integer> values) {
            addCriterion("OPERATION_TYPE in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotIn(List<Integer> values) {
            addCriterion("OPERATION_TYPE not in", values, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeBetween(Integer value1, Integer value2) {
            addCriterion("OPERATION_TYPE between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATION_TYPE not between", value1, value2, "operationType");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNull() {
            addCriterion("OPERATION_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNotNull() {
            addCriterion("OPERATION_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andOperationResultEqualTo(Integer value) {
            addCriterion("OPERATION_RESULT =", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotEqualTo(Integer value) {
            addCriterion("OPERATION_RESULT <>", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThan(Integer value) {
            addCriterion("OPERATION_RESULT >", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPERATION_RESULT >=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThan(Integer value) {
            addCriterion("OPERATION_RESULT <", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThanOrEqualTo(Integer value) {
            addCriterion("OPERATION_RESULT <=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultIn(List<Integer> values) {
            addCriterion("OPERATION_RESULT in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotIn(List<Integer> values) {
            addCriterion("OPERATION_RESULT not in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultBetween(Integer value1, Integer value2) {
            addCriterion("OPERATION_RESULT between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotBetween(Integer value1, Integer value2) {
            addCriterion("OPERATION_RESULT not between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameIsNull() {
            addCriterion("OPERATION_PICK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameIsNotNull() {
            addCriterion("OPERATION_PICK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameEqualTo(String value) {
            addCriterion("OPERATION_PICK_NAME =", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameNotEqualTo(String value) {
            addCriterion("OPERATION_PICK_NAME <>", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameGreaterThan(String value) {
            addCriterion("OPERATION_PICK_NAME >", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_PICK_NAME >=", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameLessThan(String value) {
            addCriterion("OPERATION_PICK_NAME <", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_PICK_NAME <=", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameLike(String value) {
            addCriterion("OPERATION_PICK_NAME like", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameNotLike(String value) {
            addCriterion("OPERATION_PICK_NAME not like", value, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameIn(List<String> values) {
            addCriterion("OPERATION_PICK_NAME in", values, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameNotIn(List<String> values) {
            addCriterion("OPERATION_PICK_NAME not in", values, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameBetween(String value1, String value2) {
            addCriterion("OPERATION_PICK_NAME between", value1, value2, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameNotBetween(String value1, String value2) {
            addCriterion("OPERATION_PICK_NAME not between", value1, value2, "operationPickName");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("GMT_CREATE is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("GMT_CREATE is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(String value) {
            addCriterion("GMT_CREATE =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(String value) {
            addCriterion("GMT_CREATE <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(String value) {
            addCriterion("GMT_CREATE >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(String value) {
            addCriterion("GMT_CREATE >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(String value) {
            addCriterion("GMT_CREATE <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(String value) {
            addCriterion("GMT_CREATE <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLike(String value) {
            addCriterion("GMT_CREATE like", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotLike(String value) {
            addCriterion("GMT_CREATE not like", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<String> values) {
            addCriterion("GMT_CREATE in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<String> values) {
            addCriterion("GMT_CREATE not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(String value1, String value2) {
            addCriterion("GMT_CREATE between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(String value1, String value2) {
            addCriterion("GMT_CREATE not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("GMT_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("GMT_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(String value) {
            addCriterion("GMT_MODIFIED =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(String value) {
            addCriterion("GMT_MODIFIED <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(String value) {
            addCriterion("GMT_MODIFIED >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(String value) {
            addCriterion("GMT_MODIFIED >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(String value) {
            addCriterion("GMT_MODIFIED <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(String value) {
            addCriterion("GMT_MODIFIED <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLike(String value) {
            addCriterion("GMT_MODIFIED like", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotLike(String value) {
            addCriterion("GMT_MODIFIED not like", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<String> values) {
            addCriterion("GMT_MODIFIED in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<String> values) {
            addCriterion("GMT_MODIFIED not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(String value1, String value2) {
            addCriterion("GMT_MODIFIED between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(String value1, String value2) {
            addCriterion("GMT_MODIFIED not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andOperationMsgIsNull() {
            addCriterion("OPERATION_MSG is null");
            return (Criteria) this;
        }

        public Criteria andOperationMsgIsNotNull() {
            addCriterion("OPERATION_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andOperationMsgEqualTo(String value) {
            addCriterion("OPERATION_MSG =", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgNotEqualTo(String value) {
            addCriterion("OPERATION_MSG <>", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgGreaterThan(String value) {
            addCriterion("OPERATION_MSG >", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_MSG >=", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgLessThan(String value) {
            addCriterion("OPERATION_MSG <", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_MSG <=", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgLike(String value) {
            addCriterion("OPERATION_MSG like", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgNotLike(String value) {
            addCriterion("OPERATION_MSG not like", value, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgIn(List<String> values) {
            addCriterion("OPERATION_MSG in", values, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgNotIn(List<String> values) {
            addCriterion("OPERATION_MSG not in", values, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgBetween(String value1, String value2) {
            addCriterion("OPERATION_MSG between", value1, value2, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationMsgNotBetween(String value1, String value2) {
            addCriterion("OPERATION_MSG not between", value1, value2, "operationMsg");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("OPERATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("OPERATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("OPERATION_TIME =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("OPERATION_TIME <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("OPERATION_TIME >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATION_TIME >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("OPERATION_TIME <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATION_TIME <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("OPERATION_TIME in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("OPERATION_TIME not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("OPERATION_TIME between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATION_TIME not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria and( String condition) {
            addCriterion(condition);
            return (Criteria) this;
        }

        public Criteria andOperationFunctionLikeInsensitive(String value) {
            addCriterion("upper(OPERATION_FUNCTION) like", value.toUpperCase(), "operationFunction");
            return (Criteria) this;
        }

        public Criteria andIpLikeInsensitive(String value) {
            addCriterion("upper(IP) like", value.toUpperCase(), "ip");
            return (Criteria) this;
        }

        public Criteria andOperationPickNameLikeInsensitive(String value) {
            addCriterion("upper(OPERATION_PICK_NAME) like", value.toUpperCase(), "operationPickName");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLikeInsensitive(String value) {
            addCriterion("upper(GMT_CREATE) like", value.toUpperCase(), "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLikeInsensitive(String value) {
            addCriterion("upper(GMT_MODIFIED) like", value.toUpperCase(), "gmtModified");
            return (Criteria) this;
        }

        public Criteria andOperationMsgLikeInsensitive(String value) {
            addCriterion("upper(OPERATION_MSG) like", value.toUpperCase(), "operationMsg");
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