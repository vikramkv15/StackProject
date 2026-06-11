// =============================================================================
// RegressGuard -- Auto-generated Regression Test
// Failure   : Lint / eslint
// Branch    : unknown
// Category  : lint_error
// Root cause: An unused retries variable and an unexpected console statement were left in production code
// Generated : 2026-06-11T00:00:00Z
// WARNING   : Review before merging. Auto-generated -- may require adjustments.
// =============================================================================

import { execFile } from 'node:child_process';
import { promisify } from 'node:util';

const execFileAsync = promisify(execFile);

describe('ESLint regression: no-unused-vars and no-console are not allowed', () => {
  it('passes ESLint without reporting an unused retries variable', async () => {
    const { stdout, stderr } = await execFileAsync('npx', ['eslint', '.'], {
      cwd: process.cwd(),
      maxBuffer: 10 * 1024 * 1024,
    });

    const output = `${stdout}\n${stderr}`;
    expect(output).not.toContain("'retries' is assigned a value but never used");
  });

  it('passes ESLint without reporting unexpected console statements', async () => {
    const { stdout, stderr } = await execFileAsync('npx', ['eslint', '.'], {
      cwd: process.cwd(),
      maxBuffer: 10 * 1024 * 1024,
    });

    const output = `${stdout}\n${stderr}`;
    expect(output).not.toContain('Unexpected console statement');
  });
});