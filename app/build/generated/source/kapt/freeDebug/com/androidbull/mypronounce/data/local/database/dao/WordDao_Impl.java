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
import com.androidbull.mypronounce.data.model.Word;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __updateAdapterOfWord;

  public WordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Word` (`id`,`spelling`,`phonetic`,`lessonId`,`accuracy`,`speechResult`,`isAccurate`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getSpelling() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSpelling());
        }
        if (value.getPhonetic() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhonetic());
        }
        stmt.bindLong(4, value.getLessonId());
        stmt.bindLong(5, value.getAccuracy());
        if (value.getSpeechResult() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpeechResult());
        }
        final int _tmp;
        _tmp = value.isAccurate() ? 1 : 0;
        stmt.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Word` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Word` SET `id` = ?,`spelling` = ?,`phonetic` = ?,`lessonId` = ?,`accuracy` = ?,`speechResult` = ?,`isAccurate` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getSpelling() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSpelling());
        }
        if (value.getPhonetic() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhonetic());
        }
        stmt.bindLong(4, value.getLessonId());
        stmt.bindLong(5, value.getAccuracy());
        if (value.getSpeechResult() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpeechResult());
        }
        final int _tmp;
        _tmp = value.isAccurate() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insert(final Word... word) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWord.insert(word);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(final List<Word> words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWord.insert(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Word word) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWord.handle(word);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<Word> words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWord.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Word word) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWord.handle(word);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Word> getAll() {
    final String _sql = "SELECT * FROM Word";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSpelling = CursorUtil.getColumnIndexOrThrow(_cursor, "spelling");
      final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
      final int _cursorIndexOfSpeechResult = CursorUtil.getColumnIndexOrThrow(_cursor, "speechResult");
      final int _cursorIndexOfIsAccurate = CursorUtil.getColumnIndexOrThrow(_cursor, "isAccurate");
      final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Word _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpSpelling;
        _tmpSpelling = _cursor.getString(_cursorIndexOfSpelling);
        final String _tmpPhonetic;
        _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final int _tmpAccuracy;
        _tmpAccuracy = _cursor.getInt(_cursorIndexOfAccuracy);
        final String _tmpSpeechResult;
        _tmpSpeechResult = _cursor.getString(_cursorIndexOfSpeechResult);
        final boolean _tmpIsAccurate;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAccurate);
        _tmpIsAccurate = _tmp != 0;
        _item = new Word(_tmpId,_tmpSpelling,_tmpPhonetic,_tmpLessonId,_tmpAccuracy,_tmpSpeechResult,_tmpIsAccurate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Word> loadAllByIds(final int[] Ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT ");
    _stringBuilder.append("*");
    _stringBuilder.append(" FROM Word WHERE id IN (");
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
      final int _cursorIndexOfSpelling = CursorUtil.getColumnIndexOrThrow(_cursor, "spelling");
      final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
      final int _cursorIndexOfSpeechResult = CursorUtil.getColumnIndexOrThrow(_cursor, "speechResult");
      final int _cursorIndexOfIsAccurate = CursorUtil.getColumnIndexOrThrow(_cursor, "isAccurate");
      final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Word _item_1;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpSpelling;
        _tmpSpelling = _cursor.getString(_cursorIndexOfSpelling);
        final String _tmpPhonetic;
        _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final int _tmpAccuracy;
        _tmpAccuracy = _cursor.getInt(_cursorIndexOfAccuracy);
        final String _tmpSpeechResult;
        _tmpSpeechResult = _cursor.getString(_cursorIndexOfSpeechResult);
        final boolean _tmpIsAccurate;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAccurate);
        _tmpIsAccurate = _tmp != 0;
        _item_1 = new Word(_tmpId,_tmpSpelling,_tmpPhonetic,_tmpLessonId,_tmpAccuracy,_tmpSpeechResult,_tmpIsAccurate);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Word getById(final int id) {
    final String _sql = "SELECT * FROM Word WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSpelling = CursorUtil.getColumnIndexOrThrow(_cursor, "spelling");
      final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
      final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
      final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
      final int _cursorIndexOfSpeechResult = CursorUtil.getColumnIndexOrThrow(_cursor, "speechResult");
      final int _cursorIndexOfIsAccurate = CursorUtil.getColumnIndexOrThrow(_cursor, "isAccurate");
      final Word _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpSpelling;
        _tmpSpelling = _cursor.getString(_cursorIndexOfSpelling);
        final String _tmpPhonetic;
        _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
        final int _tmpLessonId;
        _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
        final int _tmpAccuracy;
        _tmpAccuracy = _cursor.getInt(_cursorIndexOfAccuracy);
        final String _tmpSpeechResult;
        _tmpSpeechResult = _cursor.getString(_cursorIndexOfSpeechResult);
        final boolean _tmpIsAccurate;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsAccurate);
        _tmpIsAccurate = _tmp != 0;
        _result = new Word(_tmpId,_tmpSpelling,_tmpPhonetic,_tmpLessonId,_tmpAccuracy,_tmpSpeechResult,_tmpIsAccurate);
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
  public LiveData<List<Word>> getAllByLessonId(final int lessonId) {
    final String _sql = "SELECT * FROM Word WHERE lessonId IN (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, lessonId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Word"}, false, new Callable<List<Word>>() {
      @Override
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSpelling = CursorUtil.getColumnIndexOrThrow(_cursor, "spelling");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfLessonId = CursorUtil.getColumnIndexOrThrow(_cursor, "lessonId");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfSpeechResult = CursorUtil.getColumnIndexOrThrow(_cursor, "speechResult");
          final int _cursorIndexOfIsAccurate = CursorUtil.getColumnIndexOrThrow(_cursor, "isAccurate");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpSpelling;
            _tmpSpelling = _cursor.getString(_cursorIndexOfSpelling);
            final String _tmpPhonetic;
            _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            final int _tmpLessonId;
            _tmpLessonId = _cursor.getInt(_cursorIndexOfLessonId);
            final int _tmpAccuracy;
            _tmpAccuracy = _cursor.getInt(_cursorIndexOfAccuracy);
            final String _tmpSpeechResult;
            _tmpSpeechResult = _cursor.getString(_cursorIndexOfSpeechResult);
            final boolean _tmpIsAccurate;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAccurate);
            _tmpIsAccurate = _tmp != 0;
            _item = new Word(_tmpId,_tmpSpelling,_tmpPhonetic,_tmpLessonId,_tmpAccuracy,_tmpSpeechResult,_tmpIsAccurate);
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
  public int getTotalWordCount() {
    final String _sql = "SELECT COUNT(id) FROM Word";
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
  public LiveData<Integer> getAccurateWordsLive() {
    final String _sql = "SELECT COUNT(id) FROM Word where isAccurate == 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Word"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
  public int getAccurateWords() {
    final String _sql = "SELECT COUNT(id) FROM Word where isAccurate == 1";
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
