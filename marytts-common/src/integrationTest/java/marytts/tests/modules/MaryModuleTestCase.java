/**
 * Copyright 2000-2006 DFKI GmbH.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * This file is part of MARY TTS.
 *
 * MARY TTS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package marytts.tests.modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import marytts.datatypes.MaryData;
import marytts.modules.MaryModule;
import marytts.server.Mary;
import marytts.util.MaryUtils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Marc Schr&ouml;der
 *
 *
 */
public class MaryModuleTestCase {

	protected MaryModule module;

	public MaryModuleTestCase(boolean needMaryStarted) throws Exception {
		if (!MaryUtils.isLog4jConfigured()) {
			BasicConfigurator.configure();
		}
		Logger.getRootLogger().setLevel(Level.DEBUG);
		if (System.getProperty("mary.base") == null) {
			System.setProperty("mary.base", ".");
			Logger.getRootLogger().warn(
                "System property 'mary.base' is not defined -- trying " + new File(".").getAbsolutePath()
                + " -- if this fails, please start this using VM property \"-Dmary.base=/path/to/mary/runtime\"!");
		}

		if (needMaryStarted) {
			if (Mary.currentState() == Mary.STATE_OFF)
				Mary.startup();
		}
	}
}