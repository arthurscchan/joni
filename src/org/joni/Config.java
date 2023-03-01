/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.joni;

import java.io.PrintStream;

public interface Config extends org.jcodings.Config {
    final int CHAR_TABLE_SIZE = 256;
    final boolean USE_NO_INVALID_QUANTIFIER = true;
    final int SCANENV_MEMNODES_SIZE = 8;

    final boolean USE_NAMED_GROUP = true;
    final boolean USE_SUBEXP_CALL = true;
    final boolean USE_PERL_SUBEXP_CALL = true;
    final boolean USE_BACKREF_WITH_LEVEL = true;                            /* \k<name+n>, \k<name-n> */

    final boolean USE_MONOMANIAC_CHECK_CAPTURES_IN_ENDLESS_REPEAT = true; /* /(?:()|())*\2/ */
    final boolean USE_NEWLINE_AT_END_OF_STRING_HAS_EMPTY_LINE = true;     /* /\n$/ =~ "\n" */
    final boolean USE_WARNING_REDUNDANT_NESTED_REPEAT_OPERATOR = true;

    final boolean CASE_FOLD_IS_APPLIED_INSIDE_NEGATIVE_CCLASS = true;

    final boolean USE_MATCH_RANGE_MUST_BE_INSIDE_OF_SPECIFIED_RANGE = false;
    final boolean USE_CAPTURE_HISTORY = false;
    final boolean USE_VARIABLE_META_CHARS = true;
    final boolean USE_WORD_BEGIN_END = true;                                /* "\<": word-begin, "\>": word-end */
    final boolean USE_FIND_LONGEST_SEARCH_ALL_OF_RANGE = true;
    final boolean USE_SUNDAY_QUICK_SEARCH = true;
    final boolean USE_CEC = false;
    final boolean USE_DYNAMIC_OPTION = false;
    final boolean USE_BYTE_MAP = OptExactInfo.OPT_EXACT_MAXLEN <= CHAR_TABLE_SIZE;
    final boolean USE_INT_MAP_BACKWARD = false;

    final int NREGION                   = 10;
    final int MAX_BACKREF_NUM           = 1000;
    final int MAX_CAPTURE_GROUP_NUM     = 32767;
    final int MAX_REPEAT_NUM            = 100000;
    final int MAX_MULTI_BYTE_RANGES_NUM = 10000;

    // internal config
    final boolean USE_OP_PUSH_OR_JUMP_EXACT         = true;
    final boolean USE_QTFR_PEEK_NEXT                = true;

    final int INIT_MATCH_STACK_SIZE                 = 64;

    final boolean DONT_OPTIMIZE                     = false;

    final boolean USE_STRING_TEMPLATES              = true; // use embedded string templates in Regex object as byte arrays instead of compiling them into int bytecode array


    final int MAX_CAPTURE_HISTORY_GROUP             = 31;


    final int CHECK_STRING_THRESHOLD_LEN            = 7;
    final int CHECK_BUFF_MAX_SIZE                   = 0x4000;

    final PrintStream log = System.out;
    final PrintStream err = System.err;

    final boolean DEBUG_ALL                         = ConfigSupport.getBoolean("joni.debug.all", false);

    final boolean DEBUG                             = ConfigSupport.getBoolean("joni.debug", false) || DEBUG_ALL;
    final boolean DEBUG_PARSE_TREE                  = ConfigSupport.getBoolean("joni.debug.parse.tree", false) || DEBUG_ALL;
    final boolean DEBUG_PARSE_TREE_RAW              = ConfigSupport.getBoolean("joni.debug.parse.tree.raw", true) || DEBUG_ALL;
    final boolean DEBUG_COMPILE                     = ConfigSupport.getBoolean("joni.debug.compile", false) || DEBUG_ALL;
    final boolean DEBUG_COMPILE_BYTE_CODE_INFO      = ConfigSupport.getBoolean("joni.debug.compile.bytecode.info", false) || DEBUG_ALL;
    final boolean DEBUG_SEARCH                      = ConfigSupport.getBoolean("joni.debug.search", false) || DEBUG_ALL;
    final boolean DEBUG_MATCH                       = ConfigSupport.getBoolean("joni.debug.match", false) || DEBUG_ALL;
}
