def pass_code_block(&block)
    execute_code_block(&block)
end

def execute_code_block(&block)
    block.call
end

pass_code_block {puts "Hey Wiggert"}