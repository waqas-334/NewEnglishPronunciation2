package com.androidbull.mypronounce.data.local.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.androidbull.mypronounce.data.local.database.dao.DailyLessonDao;
import com.androidbull.mypronounce.data.local.database.dao.DailyLessonDao_Impl;
import com.androidbull.mypronounce.data.local.database.dao.SentenceDao;
import com.androidbull.mypronounce.data.local.database.dao.SentenceDao_Impl;
import com.androidbull.mypronounce.data.local.database.dao.SentenceLessonDao;
import com.androidbull.mypronounce.data.local.database.dao.SentenceLessonDao_Impl;
import com.androidbull.mypronounce.data.local.database.dao.WordDao;
import com.androidbull.mypronounce.data.local.database.dao.WordDao_Impl;
import com.androidbull.mypronounce.data.local.database.dao.WordLessonDao;
import com.androidbull.mypronounce.data.local.database.dao.WordLessonDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DailyLessonDao _dailyLessonDao;

  private volatile WordLessonDao _wordLessonDao;

  private volatile SentenceLessonDao _sentenceLessonDao;

  private volatile WordDao _wordDao;

  private volatile SentenceDao _sentenceDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DailyLesson` (`lessonId` INTEGER NOT NULL, `title` TEXT NOT NULL, `subtitle` TEXT NOT NULL, `description` TEXT NOT NULL, `lessonImage` TEXT NOT NULL, `isRead` INTEGER NOT NULL, PRIMARY KEY(`lessonId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WordLesson` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `subtitle` TEXT NOT NULL, `isLocked` INTEGER NOT NULL, `wordCount` INTEGER NOT NULL, `wordsCompleted` INTEGER NOT NULL, `lessonProgress` INTEGER NOT NULL, `lessonPrevProgress` INTEGER NOT NULL, `unLockThreshold` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Word` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `spelling` TEXT NOT NULL, `phonetic` TEXT NOT NULL, `lessonId` INTEGER NOT NULL, `accuracy` INTEGER NOT NULL, `speechResult` TEXT NOT NULL, `isAccurate` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SentenceLesson` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `subtitle` TEXT NOT NULL, `isLocked` INTEGER NOT NULL, `sentenceCount` INTEGER NOT NULL, `sentencesCompleted` INTEGER NOT NULL, `lessonProgress` INTEGER NOT NULL, `lessonPrevProgress` INTEGER NOT NULL, `unLockThreshold` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Sentence` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `words` TEXT NOT NULL, `phonetic` TEXT NOT NULL, `lessonId` INTEGER NOT NULL, `accuracy` INTEGER NOT NULL, `speechResult` TEXT NOT NULL, `isAccurate` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8106f84828340bd6776af7c3ac9ebc93')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `DailyLesson`");
        _db.execSQL("DROP TABLE IF EXISTS `WordLesson`");
        _db.execSQL("DROP TABLE IF EXISTS `Word`");
        _db.execSQL("DROP TABLE IF EXISTS `SentenceLesson`");
        _db.execSQL("DROP TABLE IF EXISTS `Sentence`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsDailyLesson = new HashMap<String, TableInfo.Column>(6);
        _columnsDailyLesson.put("lessonId", new TableInfo.Column("lessonId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyLesson.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyLesson.put("subtitle", new TableInfo.Column("subtitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyLesson.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyLesson.put("lessonImage", new TableInfo.Column("lessonImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDailyLesson.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDailyLesson = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDailyLesson = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailyLesson = new TableInfo("DailyLesson", _columnsDailyLesson, _foreignKeysDailyLesson, _indicesDailyLesson);
        final TableInfo _existingDailyLesson = TableInfo.read(_db, "DailyLesson");
        if (! _infoDailyLesson.equals(_existingDailyLesson)) {
          return new RoomOpenHelper.ValidationResult(false, "DailyLesson(com.androidbull.mypronounce.data.model.DailyLesson).\n"
                  + " Expected:\n" + _infoDailyLesson + "\n"
                  + " Found:\n" + _existingDailyLesson);
        }
        final HashMap<String, TableInfo.Column> _columnsWordLesson = new HashMap<String, TableInfo.Column>(9);
        _columnsWordLesson.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("subtitle", new TableInfo.Column("subtitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("isLocked", new TableInfo.Column("isLocked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("wordCount", new TableInfo.Column("wordCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("wordsCompleted", new TableInfo.Column("wordsCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("lessonProgress", new TableInfo.Column("lessonProgress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("lessonPrevProgress", new TableInfo.Column("lessonPrevProgress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordLesson.put("unLockThreshold", new TableInfo.Column("unLockThreshold", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWordLesson = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWordLesson = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWordLesson = new TableInfo("WordLesson", _columnsWordLesson, _foreignKeysWordLesson, _indicesWordLesson);
        final TableInfo _existingWordLesson = TableInfo.read(_db, "WordLesson");
        if (! _infoWordLesson.equals(_existingWordLesson)) {
          return new RoomOpenHelper.ValidationResult(false, "WordLesson(com.androidbull.mypronounce.data.model.WordLesson).\n"
                  + " Expected:\n" + _infoWordLesson + "\n"
                  + " Found:\n" + _existingWordLesson);
        }
        final HashMap<String, TableInfo.Column> _columnsWord = new HashMap<String, TableInfo.Column>(7);
        _columnsWord.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("spelling", new TableInfo.Column("spelling", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("phonetic", new TableInfo.Column("phonetic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("lessonId", new TableInfo.Column("lessonId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("accuracy", new TableInfo.Column("accuracy", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("speechResult", new TableInfo.Column("speechResult", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWord.put("isAccurate", new TableInfo.Column("isAccurate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWord = new TableInfo("Word", _columnsWord, _foreignKeysWord, _indicesWord);
        final TableInfo _existingWord = TableInfo.read(_db, "Word");
        if (! _infoWord.equals(_existingWord)) {
          return new RoomOpenHelper.ValidationResult(false, "Word(com.androidbull.mypronounce.data.model.Word).\n"
                  + " Expected:\n" + _infoWord + "\n"
                  + " Found:\n" + _existingWord);
        }
        final HashMap<String, TableInfo.Column> _columnsSentenceLesson = new HashMap<String, TableInfo.Column>(9);
        _columnsSentenceLesson.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("subtitle", new TableInfo.Column("subtitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("isLocked", new TableInfo.Column("isLocked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("sentenceCount", new TableInfo.Column("sentenceCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("sentencesCompleted", new TableInfo.Column("sentencesCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("lessonProgress", new TableInfo.Column("lessonProgress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("lessonPrevProgress", new TableInfo.Column("lessonPrevProgress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentenceLesson.put("unLockThreshold", new TableInfo.Column("unLockThreshold", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSentenceLesson = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSentenceLesson = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSentenceLesson = new TableInfo("SentenceLesson", _columnsSentenceLesson, _foreignKeysSentenceLesson, _indicesSentenceLesson);
        final TableInfo _existingSentenceLesson = TableInfo.read(_db, "SentenceLesson");
        if (! _infoSentenceLesson.equals(_existingSentenceLesson)) {
          return new RoomOpenHelper.ValidationResult(false, "SentenceLesson(com.androidbull.mypronounce.data.model.SentenceLesson).\n"
                  + " Expected:\n" + _infoSentenceLesson + "\n"
                  + " Found:\n" + _existingSentenceLesson);
        }
        final HashMap<String, TableInfo.Column> _columnsSentence = new HashMap<String, TableInfo.Column>(7);
        _columnsSentence.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("words", new TableInfo.Column("words", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("phonetic", new TableInfo.Column("phonetic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("lessonId", new TableInfo.Column("lessonId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("accuracy", new TableInfo.Column("accuracy", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("speechResult", new TableInfo.Column("speechResult", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSentence.put("isAccurate", new TableInfo.Column("isAccurate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSentence = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSentence = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSentence = new TableInfo("Sentence", _columnsSentence, _foreignKeysSentence, _indicesSentence);
        final TableInfo _existingSentence = TableInfo.read(_db, "Sentence");
        if (! _infoSentence.equals(_existingSentence)) {
          return new RoomOpenHelper.ValidationResult(false, "Sentence(com.androidbull.mypronounce.data.model.Sentence).\n"
                  + " Expected:\n" + _infoSentence + "\n"
                  + " Found:\n" + _existingSentence);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8106f84828340bd6776af7c3ac9ebc93", "0996edc25fd9287aa7ee65b0ef6e01c8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "DailyLesson","WordLesson","Word","SentenceLesson","Sentence");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `DailyLesson`");
      _db.execSQL("DELETE FROM `WordLesson`");
      _db.execSQL("DELETE FROM `Word`");
      _db.execSQL("DELETE FROM `SentenceLesson`");
      _db.execSQL("DELETE FROM `Sentence`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DailyLessonDao dailyLessonDao() {
    if (_dailyLessonDao != null) {
      return _dailyLessonDao;
    } else {
      synchronized(this) {
        if(_dailyLessonDao == null) {
          _dailyLessonDao = new DailyLessonDao_Impl(this);
        }
        return _dailyLessonDao;
      }
    }
  }

  @Override
  public WordLessonDao wordLessonDao() {
    if (_wordLessonDao != null) {
      return _wordLessonDao;
    } else {
      synchronized(this) {
        if(_wordLessonDao == null) {
          _wordLessonDao = new WordLessonDao_Impl(this);
        }
        return _wordLessonDao;
      }
    }
  }

  @Override
  public SentenceLessonDao sentenceLessonDao() {
    if (_sentenceLessonDao != null) {
      return _sentenceLessonDao;
    } else {
      synchronized(this) {
        if(_sentenceLessonDao == null) {
          _sentenceLessonDao = new SentenceLessonDao_Impl(this);
        }
        return _sentenceLessonDao;
      }
    }
  }

  @Override
  public WordDao wordDao() {
    if (_wordDao != null) {
      return _wordDao;
    } else {
      synchronized(this) {
        if(_wordDao == null) {
          _wordDao = new WordDao_Impl(this);
        }
        return _wordDao;
      }
    }
  }

  @Override
  public SentenceDao sentenceDao() {
    if (_sentenceDao != null) {
      return _sentenceDao;
    } else {
      synchronized(this) {
        if(_sentenceDao == null) {
          _sentenceDao = new SentenceDao_Impl(this);
        }
        return _sentenceDao;
      }
    }
  }
}
