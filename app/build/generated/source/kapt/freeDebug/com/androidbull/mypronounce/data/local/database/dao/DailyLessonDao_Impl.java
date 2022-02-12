package com.androidbull.mypronounce.data.local.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.androidbull.mypronounce.data.model.DailyLesson;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DailyLessonDao_Impl implements DailyLessonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DailyLesson> __insertionAdapterOfDailyLesson;

  private final EntityDeletionOrUpdateAdapter<DailyLesson> __deletionAdapterOfDailyLesson;

  private final EntityDeletionOrUpdateAdapter<DailyLesson> __updateAdapterOfDailyLesson;

  public DailyLessonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDailyLesson = new EntityInsertionAdapter<DailyLesson>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `DailyLesson` (`lessonId`,`title`,`subtitle`,`description`,`lessonImage`,`isRead`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyLesson value) {
        stmt.bindLong(1, value.getLessonId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSubtitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubtitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getLessonImage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLessonImage());
        }
        final int _tmp;
        _tmp = value.isRead() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfDailyLesson = new EntityDeletionOrUpdateAdapter<DailyLesson>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `DailyLesson` WHERE `lessonId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyLesson value) {
        stmt.bindLong(1, value.getLessonId());
      }
    };
    this.__updateAdapterOfDailyLesson = new EntityDeletionOrUpdateAdapter<DailyLesson>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `DailyLesson` SET `lessonId` = ?,`title` = ?,`subtitle` = ?,`description` = ?,`lessonImage` = ?,`isRead` = ? WHERE `lessonId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DailyLesson value) {
        stmt.bindLong(1, value.getLessonId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSubtitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubtitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
        if (value.getLessonImage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLessonImage());
        }
        final int _tmp;
        _tmp = value.isRead() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getLessonId());
      }
    };
  }

  @Override
  public void insert(final DailyLesson... dailyLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDailyLesson.insert(dailyLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<DailyLesson> dailyLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDailyLesson.insert(dailyLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final DailyLesson dailyLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDailyLesson.handle(dailyLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<DailyLesson> dailyLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDailyLesson.handleMultiple(dailyLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final DailyLesson dailyLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDailyLesson.handle(dailyLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DailyLesson> getAll() {
    final String _sql = "SELECT * FROM DailyLesson";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLessonImage = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonImage");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
      final List<DailyLesson> _result = new ArrayList<DailyLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DailyLesson _item;
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpLessonImage;
        _tmpLessonImage = _cursor.getString(_cursorIndexOfLessonImage);
        final boolean _tmpIsRead;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        _tmpIsRead = _tmp != 0;
        _item = new DailyLesson(_tmpLessonId,_tmpTitle,_tmpSubtitle,_tmpDescription,_tmpLessonImage,_tmpIsRead);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DailyLesson> loadAllByIds(final int[] lessonIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM DailyLesson WHERE lessonId IN (");
    final int _inputSize = lessonIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : lessonIds) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLessonImage = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonImage");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
      final List<DailyLesson> _result = new ArrayList<DailyLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DailyLesson _item_1;
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpLessonImage;
        _tmpLessonImage = _cursor.getString(_cursorIndexOfLessonImage);
        final boolean _tmpIsRead;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        _tmpIsRead = _tmp != 0;
        _item_1 = new DailyLesson(_tmpLessonId,_tmpTitle,_tmpSubtitle,_tmpDescription,_tmpLessonImage,_tmpIsRead);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DailyLesson getById(final int lessonId) {
    final String _sql = "SELECT * FROM DailyLesson WHERE lessonId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, lessonId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLessonImage = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonImage");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
      final DailyLesson _result;
      if(_cursor.moveToFirst()) {
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpLessonImage;
        _tmpLessonImage = _cursor.getString(_cursorIndexOfLessonImage);
        final boolean _tmpIsRead;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        _tmpIsRead = _tmp != 0;
        _result = new DailyLesson(_tmpLessonId,_tmpTitle,_tmpSubtitle,_tmpDescription,_tmpLessonImage,_tmpIsRead);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DailyLesson getUnreadLesson() {
    final String _sql = "SELECT * FROM DailyLesson WHERE isRead = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLessonImage = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonImage");
      final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
      final DailyLesson _result;
      if(_cursor.moveToFirst()) {
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpLessonImage;
        _tmpLessonImage = _cursor.getString(_cursorIndexOfLessonImage);
        final boolean _tmpIsRead;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsRead);
        _tmpIsRead = _tmp != 0;
        _result = new DailyLesson(_tmpLessonId,_tmpTitle,_tmpSubtitle,_tmpDescription,_tmpLessonImage,_tmpIsRead);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DailyLesson>> getLessons(final int from, final int To) {
    final String _sql = "SELECT * FROM DailyLesson WHERE lessonId BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, from);
    _argIndex = 2;
    _statement.bindLong(_argIndex, To);
    return __db.getInvalidationTracker().createLiveData(new String[]{"DailyLesson"}, false, new Callable<List<DailyLesson>>() {
      @Override
      public List<DailyLesson> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfLessonImage = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonImage");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final List<DailyLesson> _result = new ArrayList<DailyLesson>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DailyLesson _item;
            final int _tmpLessonId;
            _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpSubtitle;
            _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpLessonImage;
            _tmpLessonImage = _cursor.getString(_cursorIndexOfLessonImage);
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            _item = new DailyLesson(_tmpLessonId,_tmpTitle,_tmpSubtitle,_tmpDescription,_tmpLessonImage,_tmpIsRead);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int getTotalLessonCount() {
    final String _sql = "SELECT COUNT(lessonId) FROM DailyLesson";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getLessonReadCount() {
    final String _sql = "SELECT COUNT(lessonId) FROM DailyLesson WHERE isRead = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
