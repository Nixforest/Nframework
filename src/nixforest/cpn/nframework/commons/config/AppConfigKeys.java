/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.config;

/**
 * @author Nixforest
 * @date Mar 05, 2016
 */
public final class AppConfigKeys {
    public static final String LOG_PREFIX                         = "log";
    public static final String LOG_CATEGORY_KEY                   = "category";
    public static final String LOG_CATEGORY_ROOT_KEY              = "root";
    public static final String LOG_APPENDER_CLASS_KEY             = "appender.class";
    public static final String LOG_OUTPUT_TYPE_KEY                = "output.Type";
    public static final String LOG_OUTPUT_DIRECOTRY_KEY           = "output.Directory";
    public static final String LOG_OUTPUT_FILENAME_KEY            = "output.FileName";
    public static final String LOG_OUTPUT_ROTATE_DAILY_KEY        = "output.rotate.daily";
    public static final String LOG_OUTPUT_MAX_FILE_SIZE_KEY       = "output.MaxFileSize";
    public static final String LOG_OUTPUT_MAX_BACKUP_INDEX_KEY    = "output.MaxBackupIndex";
    public static final String LOG_OUTPUT_FILE_DATE_FORMAT_KEY    = "output.FileDateFormat";
    public static final String LOG_LAYOUT_CLASS_KEY               = "layout.class";
    public static final String LOG_LAYOUT_CONVERSION_PATTERN_KEY  = "layout.ConversionPattern";
    public static final String LOG_LAYOUT_DATE_FORMAT_KEY         = "layout.DateFormat";

    public static final String DATABASE_TRANSACTION_TIMING_KEY    =
            "database.transaction.start.timing";
    public static final String DB_PREFIX                          = "db";
    public static final String DB_CONNECTION_KEY                  = "connection";
    public static final String DB_NAME_KEY                        = "db.name";
    public static final String DB_VERSION_KEY                     = "db.version";
    public static final String DB_THREAD_COMMIT_KEY               = "threadcommit";
    public static final String DB_ISOLATION_LEVEL_KEY             = "isolationLevel";
    public static final String DB_LOCK_MODE_KEY                   = "lockmode";
    public static final String DB_INITIALIZE_CLASS_KEY            = "initializeClass";
    public static final String DB_UPDATE_CLASS_KEY                = "updateClass";

    public static final String HTTP_PREFIX                        = "http";
    public static final String HTTP_CONNECTION_KEY                = "connection";
    public static final String HTTP_RESPONSE_KEY                  = "response";
    public static final String HTTP_METHOD_KEY                    = "method";
    public static final String HTTP_SCHEME_KEY                    = "scheme";
    public static final String HTTP_DOMAIN_KEY                    = "domain";
    public static final String HTTP_PORT_KEY                      = "port";
    public static final String HTTP_CONNECTTIMEOUT_KEY            = "connection.timeout";
    public static final String HTTP_READTIMEOUT_KEY               = "read.timeout";
    public static final String HTTP_RETRY_COUNT_KEY               = "retry.count";
    public static final String HTTP_RETRY_STATUS_KEY              = "retry.status";
    public static final String HTTP_RETRY_DELAY_KEY               = "retry.delay";
    public static final String HTTP_PROXY_ADDRESS_KEY             = "proxy.address";
    public static final String HTTP_PROXY_PORT_KEY                = "proxy.port";
    public static final String HTTP_RESPONSE_ERROR_CODE_KEY       = "response.error.code";
    public static final String HTTP_RESPONSE_ERROR_MESSAGE_KEY    = "response.error.message";
    public static final String HTTP_RESPONSE_ENCODE_KEY           = "response.encode";
    public static final String HTTP_REQUEST_ENCODE_KEY            = "request.encode";
    public static final String HTTP_REQUEST_HEADER_ENC_KEY        = "request.header.encode";
    public static final String HTTP_REQUEST_HEADER_LANG_KEY       = "request.header.lang";
    public static final String HTTP_REQUEST_POLESTAR_JSON_KEY     = "request.polestar.json";

    public static final String SOCKET_PREFIX                      = "socket";
    public static final String SOCKET_CONNECTION_KEY              = "connection";
    public static final String SOCKET_ADDRESS_KEY                 = "address";
    public static final String SOCKET_PORT_KEY                    = "port";
    public static final String SOCKET_TIMEOUT_KEY                 = "so.timeout";

    public static final String VIEW_FIXED_FONT_USE_FLG            = "view.fixed.font.use.flg";
    public static final String VIEW_FIXED_FONT_SIZE_H1            = "view.fixed.font.size.h1";
    public static final String VIEW_FIXED_FONT_SIZE_H2            = "view.fixed.font.size.h2";
    public static final String VIEW_FIXED_FONT_SIZE_H3            = "view.fixed.font.size.h3";
    public static final String VIEW_FIXED_FONT_SIZE_H4            = "view.fixed.font.size.h4";
    public static final String VIEW_FIXED_FONT_SIZE_H5            = "view.fixed.font.size.h5";
    public static final String VIEW_FIXED_FONT_SIZE_H6            = "view.fixed.font.size.h6";
    public static final String VIEW_FIXED_FONT_UNIT               = "view.fixed.font.unit";
    public static final String VIEW_ERROR_EDIT_FONT_COLOR         = "view.error.edit.font.color";

    /**
     * Default constructor.
     */
    private AppConfigKeys() {
    }
}
