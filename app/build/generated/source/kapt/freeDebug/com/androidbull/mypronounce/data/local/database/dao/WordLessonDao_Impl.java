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
import com.androidbull.mypronounce.data.model.WordLesson;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordLessonDao_Impl implements WordLessonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WordLesson> __insertionAdapterOfWordLesson;

  private final EntityDeletionOrUpdateAdapter<WordLesson> __deletionAdapterOfWordLesson;

  private final EntityDeletionOrUpdateAdapter<WordLesson> __updateAdapterOfWordLesson;

  private final SharedSQLiteStatement __preparedStmtOfUnLockWordLesson;

  private final SharedSQLiteStatement __preparedStmtOfUnLockAllLessons;

  public WordLessonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWordLesson = new EntityInsertionAdapter<WordLesson>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `WordLesson` (`id`,`title`,`subtitle`,`isLocked`,`wordCount`,`wordsCompleted`,`lessonProgress`,`lessonPrevProgress`,`unLockThreshold`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordLesson value) {
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
        stmt.bindLong(5, value.getWordCount());
        stmt.bindLong(6, value.getWordsCompleted());
        stmt.bindLong(7, value.getLessonProgress());
        stmt.bindLong(8, value.getLessonPrevProgress());
        stmt.bindLong(9, value.getUnLockThreshold());
      }
    };
    this.__deletionAdapterOfWordLesson = new EntityDeletionOrUpdateAdapter<WordLesson>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `WordLesson` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordLesson value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfWordLesson = new EntityDeletionOrUpdateAdapter<WordLesson>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `WordLesson` SET `id` = ?,`title` = ?,`subtitle` = ?,`isLocked` = ?,`wordCount` = ?,`wordsCompleted` = ?,`lessonProgress` = ?,`lessonPrevProgress` = ?,`unLockThreshold` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WordLesson value) {
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
        stmt.bindLong(5, value.getWordCount());
        stmt.bindLong(6, value.getWordsCompleted());
        stmt.bindLong(7, value.getLessonProgress());
        stmt.bindLong(8, value.getLessonPrevProgress());
        stmt.bindLong(9, value.getUnLockThreshold());
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfUnLockWordLesson = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE WordLesson SET isLocked = 0 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUnLockAllLessons = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE WordLesson SET isLocked = 0 WHERE isLocked = 1";
        return _query;
      }
    };
  }

  @Override
  public void insert(final WordLesson... wordLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWordLesson.insert(wordLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<WordLesson> wordLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWordLesson.insert(wordLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final WordLesson wordLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWordLesson.handle(wordLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<WordLesson> wordLessons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWordLesson.handleMultiple(wordLessons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final WordLesson wordLesson) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWordLesson.handle(wordLesson);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void unLockWordLesson(final int lessonId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUnLockWordLesson.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, lessonId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUnLockWordLesson.release(_stmt);
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
  public List<WordLesson> getAll() {
    final String _sql = "SELECT * FROM WordLesson";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final int _cursorIndexOfWordsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final List<WordLesson> _result = new ArrayList<WordLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordLesson _item;
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
        final int _tmpWordCount;
        _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
        final int _tmpWordsCompleted;
        _tmpWordsCompleted = _cursor.getInt(_cursorIndexOfWordsCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _item = new WordLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpWordCount,_tmpWordsCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WordLesson> getAllWithChildCount() {
    final String _sql = "select * , (select COUNT(*) from Word w where w.lessonId = wl.id AND w.isAccurate == 1) wordsCompleted , (select COUNT(*) from Word w where w.lessonId = wl.id) wordCount from WordLesson wl";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final int _cursorIndexOfWordsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final int _cursorIndexOfWordsCompleted_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfWordCount_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final List<WordLesson> _result = new ArrayList<WordLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordLesson _item;
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
        final int _tmpWordCount;
        _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
        final int _tmpWordsCompleted;
        _tmpWordsCompleted = _cursor.getInt(_cursorIndexOfWordsCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        final int _tmpWordsCompleted_1;
        _tmpWordsCompleted_1 = _cursor.getInt(_cursorIndexOfWordsCompleted_1);
        final int _tmpWordCount_1;
        _tmpWordCount_1 = _cursor.getInt(_cursorIndexOfWordCount_1);
        _item = new WordLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpWordCount,_tmpWordsCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<WordLesson> loadAllByIds(final int[] Ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM WordLesson WHERE id IN (");
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
      final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final int _cursorIndexOfWordsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final List<WordLesson> _result = new ArrayList<WordLesson>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WordLesson _item_1;
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
        final int _tmpWordCount;
        _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
        final int _tmpWordsCompleted;
        _tmpWordsCompleted = _cursor.getInt(_cursorIndexOfWordsCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _item_1 = new WordLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpWordCount,_tmpWordsCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WordLesson getById(final int id) {
    final String _sql = "SELECT * FROM WordLesson WHERE id = ?";
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
      final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final int _cursorIndexOfWordsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final WordLesson _result;
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
        final int _tmpWordCount;
        _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
        final int _tmpWordsCompleted;
        _tmpWordsCompleted = _cursor.getInt(_cursorIndexOfWordsCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _result = new WordLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpWordCount,_tmpWordsCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
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
  public WordLesson getLockedLesson() {
    final String _sql = "SELECT * FROM WordLesson WHERE isLocked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfIsLocked = CursorUtil.getColumnIndexOrThrow(_cursor, "isLocked");
      final int _cursorIndexOfWordCount = CursorUtil.getColumnIndexOrThrow(_cursor, "wordCount");
      final int _cursorIndexOfWordsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsCompleted");
      final int _cursorIndexOfLessonProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonProgress");
      final int _cursorIndexOfLessonPrevProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonPrevProgress");
      final int _cursorIndexOfUnLockThreshold = CursorUtil.getColumnIndexOrThrow(_cursor, "unLockThreshold");
      final WordLesson _result;
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
        final int _tmpWordCount;
        _tmpWordCount = _cursor.getInt(_cursorIndexOfWordCount);
        final int _tmpWordsCompleted;
        _tmpWordsCompleted = _cursor.getInt(_cursorIndexOfWordsCompleted);
        final int _tmpLessonProgress;
        _tmpLessonProgress = _cursor.getInt(_cursorIndexOfLessonProgress);
        final int _tmpLessonPrevProgress;
        _tmpLessonPrevProgress = _cursor.getInt(_cursorIndexOfLessonPrevProgress);
        final int _tmpUnLockThreshold;
        _tmpUnLockThreshold = _cursor.getInt(_cursorIndexOfUnLockThreshold);
        _result = new WordLesson(_tmpId,_tmpTitle,_tmpSubtitle,_tmpIsLocked,_tmpWordCount,_tmpWordsCompleted,_tmpLessonProgress,_tmpLessonPrevProgress,_tmpUnLockThreshold);
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
    final String _sql = "SELECT COUNT(id) FROM WordLesson";
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
    final String _sql = "SELECT COUNT(id) FROM WordLesson WHERE isLocked = 1";
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
    final String _sql = "SELECT id,unLockThreshold FROM WordLesson where unLockThreshold > 0";
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
