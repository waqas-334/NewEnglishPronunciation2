package com.androidbull.mypronounce.data.local.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.androidbull.mypronounce.data.model.LessonTuple;
import com.androidbull.mypronounce.data.model.SentenceLesson;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SentenceLessonDao_Impl implements SentenceLessonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SentenceLesson> __insertionAdapterOfSentenceLesson;

  private final EntityDeletionOrUpdateAdapter<SentenceLesson> __deletionAdapterOfSentenceLesson;

  private final EntityDeletionOrUpdateAdapter<SentenceLesson> __updateAdapterOfSentenceLesson;

  private final SharedSQLiteStatement __preparedStmtOfUnLockSentenceLesson;

  private final SharedSQLiteStatement __preparedStmtOfUnLockAllLessons;

  public SentenceLessonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSentenceLesson = new EntityInsertionAdapter<SentenceLesson>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `SentenceLesson` (`id`,`title`,`subtitle`,`isLocked`,`sentenceCount`,`sentencesCompleted`,`lessonProgress`,`lessonPrevProgress`,`unLockThreshold`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SentenceLesson value) {
        stmt.bindLong(1, value.getId());
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
        final int _tmp;
        _tmp = value.isLocked() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getSentenceCount());
        stmt.bindLong(6, value.getSentencesCompleted());
        stmt.bindLong(7, value.getLessonProgress());
        stmt.bindLong(8, value.getLessonPrevProgress());
        stmt.bindLong(9, value.getUnLockThreshold());
      }
    };
    this.__deletionAdapterOfSentenceLesson = new EntityDeletionOrUpdateAdapter<SentenceLesson>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `SentenceLesson` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SentenceLesson value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSentenceLesson = new EntityDeletionOrUpdateAdapter<SentenceLesson>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `SentenceLesson` SET `id` = ?,`title` = ?,`subtitle` = ?,`isLocked` = ?,`sentenceCount` = ?,`sentencesCompleted` = ?,`lessonProgress` = ?,`lessonPrevProgress` = ?,`unLockThreshold` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SentenceLesson value) {
        stmt.bindLong(1, value.getId());
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
        final int _tmp;
        _tmp = value.isLocked() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getSentenceCount());
        stmt.bindLong(6, value.getSentencesCompleted());
        stmt.bindLong(7, value.getLessonProgress());
        stmt.bindLong(8, value.getLessonPrevProgress());
        stmt.bindLong(9, value.getUnLockThreshold());
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfUnLockSentenceLesson = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE SentenceLesson SET isLocked = 0 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUnLockAllLessons = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE SentenceLesson SET isLocked = 0 WHERE isLocked = 1";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SentenceLesson... sentenceLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSentenceLesson.insert(sentenceLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<SentenceLesson> sentenceLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSentenceLesson.insert(sentenceLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SentenceLesson sentenceLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSentenceLesson.handle(sentenceLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<SentenceLesson> sentenceLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSentenceLesson.handleMultiple(sentenceLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SentenceLesson sentenceLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSentenceLesson.handle(sentenceLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void unLockSentenceLesson(final int lessonId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUnLockSentenceLesson.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, lessonId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUnLockSentenceLesson.release(_stmt);
    }
  }

  @Override
  public void unLockAllLessons() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUnLockAllLessons.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUnLockAllLessons.release(_stmt);
    }
  }

  @Override
  public List<SentenceLesson> getAll() {
    final String _sql = "SELECT * FROM SentenceLesson";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfSentenceCount = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final int _cursorIndexOfSentencesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final List<SentenceLesson> _result = new ArrayList<SentenceLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SentenceLesson _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final boolean _tmpIsLocked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsLocked);
        _tmpIsLocked = _tmp != 0;
        final int _tmpSentenceCount;
        _tmpSentenceCount = _cursor.getInt(_cursorIndexOfSentenceCount);
        final int _tmpSentencesCompleted;
        _tmpSentencesCompleted = _cursor.getInt(_cursorIndexOfSentencesCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _item = new SentenceLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpSentenceCount,_tmpSentencesCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SentenceLesson> getAllWithChildCount() {
    final String _sql = "select * , (select COUNT(*) from Sentence s where s.lessonId = sl.id AND s.isAccurate == 1) sentencesCompleted , (select COUNT(*) from Sentence s where s.lessonId = sl.id) sentenceCount from SentenceLesson sl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfSentenceCount = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final int _cursorIndexOfSentencesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final int _cursorIndexOfSentencesCompleted_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfSentenceCount_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final List<SentenceLesson> _result = new ArrayList<SentenceLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SentenceLesson _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final boolean _tmpIsLocked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsLocked);
        _tmpIsLocked = _tmp != 0;
        final int _tmpSentenceCount;
        _tmpSentenceCount = _cursor.getInt(_cursorIndexOfSentenceCount);
        final int _tmpSentencesCompleted;
        _tmpSentencesCompleted = _cursor.getInt(_cursorIndexOfSentencesCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        final int _tmpSentencesCompleted_1;
        _tmpSentencesCompleted_1 = _cursor.getInt(_cursorIndexOfSentencesCompleted_1);
        final int _tmpSentenceCount_1;
        _tmpSentenceCount_1 = _cursor.getInt(_cursorIndexOfSentenceCount_1);
        _item = new SentenceLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpSentenceCount,_tmpSentencesCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SentenceLesson> loadAllByIds(final int[] Ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM SentenceLesson WHERE id IN (");
    final int _inputSize = Ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int _item : Ids) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfSentenceCount = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final int _cursorIndexOfSentencesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final List<SentenceLesson> _result = new ArrayList<SentenceLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SentenceLesson _item_1;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final boolean _tmpIsLocked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsLocked);
        _tmpIsLocked = _tmp != 0;
        final int _tmpSentenceCount;
        _tmpSentenceCount = _cursor.getInt(_cursorIndexOfSentenceCount);
        final int _tmpSentencesCompleted;
        _tmpSentencesCompleted = _cursor.getInt(_cursorIndexOfSentencesCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _item_1 = new SentenceLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpSentenceCount,_tmpSentencesCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SentenceLesson getById(final int id) {
    final String _sql = "SELECT * FROM SentenceLesson WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfSentenceCount = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final int _cursorIndexOfSentencesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final SentenceLesson _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final boolean _tmpIsLocked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsLocked);
        _tmpIsLocked = _tmp != 0;
        final int _tmpSentenceCount;
        _tmpSentenceCount = _cursor.getInt(_cursorIndexOfSentenceCount);
        final int _tmpSentencesCompleted;
        _tmpSentencesCompleted = _cursor.getInt(_cursorIndexOfSentencesCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _result = new SentenceLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpSentenceCount,_tmpSentencesCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
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
  public SentenceLesson getLockedLesson() {
    final String _sql = "SELECT * FROM SentenceLesson WHERE isLocked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfSentenceCount = CursorUtil.getColumnIndexOrThrow(_cursor, "sentenceCount");
      final int _cursorIndexOfSentencesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "sentencesCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final SentenceLesson _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpSubtitle;
        _tmpSubtitle = _cursor.getString(_cursorIndexOfSubtitle);
        final boolean _tmpIsLocked;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsLocked);
        _tmpIsLocked = _tmp != 0;
        final int _tmpSentenceCount;
        _tmpSentenceCount = _cursor.getInt(_cursorIndexOfSentenceCount);
        final int _tmpSentencesCompleted;
        _tmpSentencesCompleted = _cursor.getInt(_cursorIndexOfSentencesCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _result = new SentenceLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpSentenceCount,_tmpSentencesCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
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
  public int getTotalLessonCount() {
    final String _sql = "SELECT COUNT(id) FROM SentenceLesson";
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
  public int getLessonLockedCount() {
    final String _sql = "SELECT COUNT(id) FROM SentenceLesson WHERE isLocked = 1";
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
  public List<LessonTuple> getLessonUnlockThresholds() {
    final String _sql = "SELECT id,unLockThreshold FROM SentenceLesson where unLockThreshold > 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final List<LessonTuple> _result = new ArrayList<LessonTuple>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LessonTuple _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _item = new LessonTuple(_tmpId,_tmpUnLockThreshold);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
