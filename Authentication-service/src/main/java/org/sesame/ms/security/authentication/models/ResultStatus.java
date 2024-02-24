package org.sesame.ms.security.authentication.models;


    public enum ResultStatus {
        SUCCESS(200, "success"),
        CREATED(201, "created"),
        BAD_REQUEST(400, "bad request"),
        UNAUTHORIZED(401, "unauthorized"),
        FORBIDDEN(403, "forbidden"),
        NOT_FOUND(404, "not found"),
        INTERNAL_SERVER_ERROR(500, "Internal server error");

        private int code;
        private String message;

        private ResultStatus(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


